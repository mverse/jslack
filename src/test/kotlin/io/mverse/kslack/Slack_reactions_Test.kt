package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsAddRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsGetRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsListRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsRemoveRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_reactions_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test

  fun test() = runBlocking {
    val channel = slack.channelsList(ChannelsListRequest(token, isExcludeArchived = (true)))
        .channels!![0].id

    val postMessage = slack.chatPostMessage(ChatPostMessageRequest(
        token = token,
        channel = channel,
        text = "hello"))
    assertThat(postMessage.ok, `is`(true))

    val timestamp = postMessage.ts
    val addResponse = slack.reactionsAdd(ReactionsAddRequest(
        token = token,
        name = "smile",
        channel = channel,
        timestamp = timestamp))
    assertThat(addResponse.ok, `is`(true))

    val getResponse = slack.reactionsGet(ReactionsGetRequest(
        token = token,
        channel = channel,
        timestamp = timestamp))
    assertThat(getResponse.ok, `is`(true))

    val removeResponse = slack.reactionsRemove(ReactionsRemoveRequest(
        token = token,
        name = "smile",
        channel = channel,
        timestamp = timestamp))
    assertThat(removeResponse.ok, `is`(true))
  }

  @Test

  fun list() = runBlocking {
    val user = slack.usersList(UsersListRequest(token))
        .members!![0].id

    val response = slack.reactionsList(ReactionsListRequest(
        token = token,
        user = user))
    assertThat(response.ok, `is`(true))
    assertThat(response.items, `is`(notNullValue()))
  }
}