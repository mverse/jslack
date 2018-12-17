package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.files.FilesDeleteRequest
import io.mverse.kslack.api.methods.request.files.FilesInfoRequest
import io.mverse.kslack.api.methods.request.files.FilesListRequest
import io.mverse.kslack.api.methods.request.files.FilesRevokePublicURLRequest
import io.mverse.kslack.api.methods.request.files.FilesSharedPublicURLRequest
import io.mverse.kslack.api.methods.request.files.FilesUploadRequest
import io.mverse.kslack.api.methods.request.files.comments.FilesCommentsAddRequest
import io.mverse.kslack.api.methods.request.files.comments.FilesCommentsDeleteRequest
import io.mverse.kslack.api.methods.request.files.comments.FilesCommentsEditRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.File
import java.io.IOException

class Slack_files_Test {

  internal var slack = io.mverse.kslack.Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun describe() {
    run {
      val response = slack.methods().filesList(FilesListRequest(token))
      assertThat(response.ok, `is`(true))
      assertThat(response.files, `is`(notNullValue()))
    }
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun createFileAndComments() {
    val channels = slack.methods().channelsList(ChannelsListRequest(token))
        .channels?.filter { it.name == "general" }?.map { it.id }?.toList()

    val file = File("src/test/resources/sample.txt")
    val fileObj: io.mverse.kslack.api.model.File?
    run {
      val response = slack.methods().filesUpload(FilesUploadRequest(
          token = token,
          channels = channels!!,
          file = file,
          filename = "sample.txt",
          initialComment = "initial comment",
          title = "file title"))
      assertThat(response.ok, `is`(true))
      fileObj = response.file
    }

    run {
      val response = slack.methods().filesInfo(FilesInfoRequest(
          token = token,
          file = fileObj!!.id))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().filesSharedPublicURL(
          FilesSharedPublicURLRequest(token, file = (fileObj!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().filesRevokePublicURL(
          FilesRevokePublicURLRequest(token, file = (fileObj!!.id)))
      assertThat(response.ok, `is`(true))
    }

    // comments
    run {
      val addResponse = slack.methods().filesCommentsAdd(FilesCommentsAddRequest(
          token = token,
          file = fileObj!!.id,
          comment = "test comment"))
      assertThat(addResponse.ok, `is`(true))

      val editResponse = slack.methods().filesCommentEdit(FilesCommentsEditRequest(
          token = token,
          file = fileObj.id,
          id = addResponse.comment!!.id,
          comment = "modified comment"))
      assertThat(editResponse.ok, `is`(true))

      val deleteResponse = slack.methods().filesCommentsDelete(FilesCommentsDeleteRequest(
          token = token,
          file = fileObj.id,
          id = addResponse.comment!!.id))

      assertThat(deleteResponse.ok, `is`(true))
    }

    run {
      val response = slack.methods().filesDelete(FilesDeleteRequest(
          token = token,
          file = fileObj!!.id))
      assertThat(response.ok, `is`(true))
    }
  }
}