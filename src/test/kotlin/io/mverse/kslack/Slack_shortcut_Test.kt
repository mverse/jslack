package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.model.Attachment
import io.mverse.kslack.shortcut.model.ApiToken
import io.mverse.kslack.shortcut.model.ChannelName
import io.mverse.kslack.shortcut.model.ReactionName
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException
import java.util.*

class Slack_shortcut_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun chatOps() {
    val shortcut = slack.shortcut(token)
    val channelName = "general"

    val channelId = shortcut.findChannelIdByName(channelName)
    assertThat(channelId.isPresent, `is`(true))

    val maybeChannelName = shortcut.findChannelNameById(channelId.get())
    assertThat(maybeChannelName.isPresent, `is`(true))
    assertThat(maybeChannelName.get(), `is`<ChannelName>(channelName))

    val messages = shortcut.findRecentMessagesByName(channelName)
    assertThat(messages, `is`(notNullValue()))

    val searchResult = shortcut.search("hello")
    assertThat(searchResult, `is`(notNullValue()))

    val reactionName = "smile"
    val addReaction = shortcut.addReaction(messages[0], reactionName)
    assertThat(addReaction.ok, `is`(true))
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun postMessage() {
    val shortcut = slack.shortcut(token)
    val attachment = Attachment(text = ("text"), footer = ("footer"))
    val attachments = Arrays.asList<Attachment>(attachment)

    run {
      val response = shortcut.post("general", "hello, hello!")
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = shortcut.postAsBot("general", "hello, hello!")
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = shortcut.post("general", "Hi, these are my attachments!", attachments)
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = shortcut.postAsBot("general", "Hi, these are my attachments!", attachments)
      assertThat(response.ok, `is`(true))
    }
  }
}