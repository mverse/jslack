package io.mverse.kslack

import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.im.ImCloseRequest
import io.mverse.kslack.api.methods.request.im.ImHistoryRequest
import io.mverse.kslack.api.methods.request.im.ImListRequest
import io.mverse.kslack.api.methods.request.im.ImMarkRequest
import io.mverse.kslack.api.methods.request.im.ImOpenRequest
import io.mverse.kslack.api.methods.request.im.ImRepliesRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import io.mverse.kslack.api.model.ResponseMetadata
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_im_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(Exception::class)
  fun operations() {
    val listResponse = slack.imList(ImListRequest(
        token = token,
        limit = 2))
    assertThat(listResponse.ok, `is`(true))
    assertThat<ResponseMetadata>(listResponse.responseMetadata, `is`(notNullValue()))

    val usersListResponse = slack.usersList(UsersListRequest(
        token = token,
        isPresence = true))
    val users = usersListResponse.members
    val userId = users!![0].id

    val openResponse = slack.imOpen(ImOpenRequest(
        token = token,
        user = userId))
    assertThat(openResponse.ok, `is`(true))

    val channelId = openResponse.channel!!.id

    val markResponse = slack.imMark(ImMarkRequest(
        token = token,
        channel = channelId,
        ts="1355517523.000005"))
    assertThat(markResponse.toString(), markResponse.ok, `is`(true))

    val firstMessageResponse = slack.chatPostMessage(ChatPostMessageRequest(
        token = token,
        channel = channelId,
        text = "Hi!"))
    assertThat(firstMessageResponse.ok, `is`(true))

    val threadReplyResponse = slack.chatPostMessage(ChatPostMessageRequest(
        token = token,
        channel = channelId,
        threadTs = firstMessageResponse.ts,
        text = "Hi!"))
    assertThat(threadReplyResponse.ok, `is`(true))

    val repliesResponse = slack.imReplies(ImRepliesRequest(
        token = token,
        channel = channelId,
        threadTs = threadReplyResponse.message!!.threadTs))
    assertThat(repliesResponse.ok, `is`(true))

    val historyResponse = slack.imHistory(ImHistoryRequest(
        token = token,
        channel = channelId))
    assertThat(historyResponse.ok, `is`(true))

    val closeResponse = slack.imClose(ImCloseRequest(
        token = token,
        channel = channelId))
    assertThat(closeResponse.ok, `is`(true))
  }
}