package io.mverse.kslack

import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.files.FilesUploadRequest
import io.mverse.kslack.api.methods.request.stars.StarsAddRequest
import io.mverse.kslack.api.methods.request.stars.StarsListRequest
import io.mverse.kslack.api.methods.request.stars.StarsRemoveRequest
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.File

class Slack_stars_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  fun list() = runBlocking {
    val response = slack.starsList(StarsListRequest(token))
    assertThat(response.ok, `is`(true))
    assertThat(response.items, `is`(notNullValue()))
  }

  @Test
  fun add() = runBlocking {
    val channels = slack.channelsList(ChannelsListRequest(token))
        .channels!!
        .filter { it.name == "general" }
        .map { it.id }

    val file = File("src/test/resources/sample.txt")
    val fileObj: io.mverse.kslack.api.model.File?
    run {
      val response = slack.filesUpload(FilesUploadRequest(
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
      val response = slack.starsAdd(StarsAddRequest(
          token = token,
          channel = channels[0],
          file = fileObj!!.id
      ))
      assertThat(response.ok, `is`(true))
    }
    run {
      val response = slack.starsRemove(StarsRemoveRequest(
          token = token,
          channel = channels[0],
          file = fileObj!!.id
      ))
      assertThat(response.ok, `is`(true))
    }

    run {
      // as of August 2018, File object no longer contains initialComment.
      if (fileObj!!.initialComment != null) {
        val response = slack.starsAdd(StarsAddRequest(
            token = token,
            channel = channels[0],
            fileComment = fileObj.initialComment!!.id
        ))
        assertThat(response.ok, `is`(true))
      }
    }
  }
}