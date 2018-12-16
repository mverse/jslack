package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.request.channels.ChannelsListRequest
import com.github.seratch.jslack.api.methods.request.files.FilesUploadRequest
import com.github.seratch.jslack.api.methods.request.stars.StarsAddRequest
import com.github.seratch.jslack.api.methods.request.stars.StarsListRequest
import com.github.seratch.jslack.api.methods.request.stars.StarsRemoveRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.File

class Slack_stars_Test {

  internal var slack = Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  fun list() {
    val response = slack.methods().starsList(StarsListRequest(token))
    assertThat(response.ok, `is`(true))
    assertThat(response.items, `is`(notNullValue()))
  }

  @Test
  fun add() {
    val channels = slack.methods().channelsList(ChannelsListRequest(token))
        .channels!!
        .filter { it.name == "general" }
        .map { it.id }

    val file = File("src/test/resources/sample.txt")
    val fileObj: com.github.seratch.jslack.api.model.File?
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
      val response = slack.methods().starsAdd(StarsAddRequest(
          token = token,
          channel = channels[0],
          file = fileObj!!.id
      ))
      assertThat(response.ok, `is`(true))
    }
    run {
      val response = slack.methods().starsRemove(StarsRemoveRequest(
          token = token,
          channel = channels[0],
          file = fileObj!!.id
      ))
      assertThat(response.ok, `is`(true))
    }

    run {
      // as of August 2018, File object no longer contains initialComment.
      if (fileObj!!.initialComment != null) {
        val response = slack.methods().starsAdd(StarsAddRequest(
            token = token,
            channel = channels[0],
            fileComment = fileObj.initialComment!!.id
        ))
        assertThat(response.ok, `is`(true))
      }
    }
  }
}