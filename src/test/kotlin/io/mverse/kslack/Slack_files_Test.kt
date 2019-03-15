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
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.File
import java.io.IOException

class Slack_files_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test

  fun describe() = runBlocking {
    run {
      val response = slack.filesList(FilesListRequest(token))
      assertThat(response.ok, `is`(true))
      assertThat(response.files, `is`(notNullValue()))
    }
  }

  @Test

  fun createFileAndComments() = runBlocking {
    val channels = slack.channelsList(ChannelsListRequest(token))
        .channels?.filter { it.name == "general" }?.map { it.id }?.toList()

    val file = File("src/test/resources/sample.txt")
    val fileObj: io.mverse.kslack.api.model.File?
    run {
      val response = slack.filesUpload(FilesUploadRequest(
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
      val response = slack.filesInfo(FilesInfoRequest(
          token = token,
          file = fileObj!!.id))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.filesSharedPublicURL(
          FilesSharedPublicURLRequest(token, file = (fileObj!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.filesRevokePublicURL(
          FilesRevokePublicURLRequest(token, file = (fileObj!!.id)))
      assertThat(response.ok, `is`(true))
    }

    // comments
    run {
      val addResponse = slack.filesCommentsAdd(FilesCommentsAddRequest(
          token = token,
          file = fileObj!!.id,
          comment = "test comment"))
      assertThat(addResponse.ok, `is`(true))

      val editResponse = slack.filesCommentEdit(FilesCommentsEditRequest(
          token = token,
          file = fileObj.id,
          id = addResponse.comment!!.id,
          comment = "modified comment"))
      assertThat(editResponse.ok, `is`(true))

      val deleteResponse = slack.filesCommentsDelete(FilesCommentsDeleteRequest(
          token = token,
          file = fileObj.id,
          id = addResponse.comment!!.id))

      assertThat(deleteResponse.ok, `is`(true))
    }

    run {
      val response = slack.filesDelete(FilesDeleteRequest(
          token = token,
          file = fileObj!!.id))
      assertThat(response.ok, `is`(true))
    }
  }
}