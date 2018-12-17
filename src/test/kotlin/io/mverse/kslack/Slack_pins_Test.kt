package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.files.FilesUploadRequest
import io.mverse.kslack.api.methods.request.pins.PinsAddRequest
import io.mverse.kslack.api.methods.request.pins.PinsListRequest
import io.mverse.kslack.api.methods.request.pins.PinsRemoveRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.File
import java.io.IOException

class Slack_pins_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun list() {
    val channels = slack.methods().channelsList(ChannelsListRequest(token))
        .channels!!.filter { it.name == "general" }.map { it.id }

    val response = slack.methods().pinsList(
        PinsListRequest(token, channel = (channels[0])))
    assertThat(response.ok, `is`(true))
    assertThat(response.items, `is`(notNullValue()))
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun add() {
    val channels = slack.methods().channelsList(ChannelsListRequest(token))
        .channels!!.filter { it.name == "general" }.map { it.id }

    val file = File("src/test/resources/sample.txt")
    val fileObj: io.mverse.kslack.api.model.File?
    run {
      val response = slack.methods().filesUpload(FilesUploadRequest(
          token = token,
          channels = channels,
          file = file,
          filename = "sample.txt",
          initialComment = "initial comment",
          title = "file title"
      ))
      assertThat(response.ok, `is`(true))
      fileObj = response.file
    }

    run {
      val response = slack.methods().pinsAdd(PinsAddRequest(
          token = token,
          channel = channels[0],
          file = fileObj!!.id
      ))
      assertThat(response.ok, `is`(true))
    }
    run {
      val response = slack.methods().pinsRemove(PinsRemoveRequest(
          token = token,
          channel = channels[0],
          file = fileObj!!.id
      ))
      assertThat(response.ok, `is`(true))
    }

    run {
      // as of August 2018, File object no longer contains initialComment.
      if (fileObj!!.initialComment != null) {
        val response = slack.methods().pinsAdd(PinsAddRequest(
            token = token,
            channel = channels[0],
            fileComment = fileObj.initialComment!!.id
        ))
        assertThat(response.ok, `is`(true))
      }
    }
  }
}