package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.channels.ChannelsListRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsAddRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsGetRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsListRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsRemoveRequest
import com.github.seratch.jslack.api.methods.request.users.UsersListRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_reactions_Test {

  internal var slack = Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun test() {
    val channel = slack.methods().channelsList(ChannelsListRequest(token, isExcludeArchived = (true)))
        .channels!![0].id

    val postMessage = slack.methods().chatPostMessage(ChatPostMessageRequest(
        token = token,
        channel = channel,
        text = "hello"))
    assertThat(postMessage.ok, `is`(true))

    val timestamp = postMessage.ts
    val addResponse = slack.methods().reactionsAdd(ReactionsAddRequest(
        token = token,
        name = "smile",
        channel = channel,
        timestamp = timestamp))
    assertThat(addResponse.ok, `is`(true))

    val getResponse = slack.methods().reactionsGet(ReactionsGetRequest(
        token = token,
        channel = channel,
        timestamp = timestamp))
    assertThat(getResponse.ok, `is`(true))

    val removeResponse = slack.methods().reactionsRemove(ReactionsRemoveRequest(
        token = token,
        name = "smile",
        channel = channel,
        timestamp = timestamp))
    assertThat(removeResponse.ok, `is`(true))
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun list() {
    val user = slack.methods().usersList(UsersListRequest(token))
        .members!![0].id

    val response = slack.methods().reactionsList(ReactionsListRequest(
        token = token,
        user = user))
    assertThat(response.ok, `is`(true))
    assertThat(response.items, `is`(notNullValue()))
  }
}