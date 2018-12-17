package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.chat.ChatDeleteRequest
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class ExamplesTest {

  internal var slack = io.mverse.kslack.Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class, InterruptedException::class)
  fun postAMessageToGeneralChannel() {

    // find all channels in the team
    val channelsResponse = slack.methods().channelsList(ChannelsListRequest(token))
    assertThat(channelsResponse.toString(), channelsResponse.ok, `is`(true))
    // find #general
    val (id) = channelsResponse.channels!!.stream()
        .filter { (_, name) -> name == "general" }.findFirst().get()

    // https://slack.com/api/chat.postMessage
    val postResponse = slack.methods().chatPostMessage(ChatPostMessageRequest(
        token = token,
        channel = id,
        text = "Hello World!"))
    assertThat(postResponse.ok, `is`(true))

    // timestamp of the posted message
    val messageTimestamp = postResponse.message!!.ts

    Thread.sleep(1000L)

    val deleteResponse = slack.methods().chatDelete(ChatDeleteRequest(
        token = token,
        channel = id,
        ts = messageTimestamp))
    assertThat(deleteResponse.ok, `is`(true))
  }
}
