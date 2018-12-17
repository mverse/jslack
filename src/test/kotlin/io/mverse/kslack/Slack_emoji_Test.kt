package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.emoji.EmojiListRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_emoji_Test {

  internal var slack = io.mverse.kslack.Slack()

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun emoji() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    run {
      val response = slack.emojiList(EmojiListRequest(token))
      assertThat(response.ok, `is`(true))
      assertThat<Map<String, String>>(response.emoji, `is`(notNullValue()))
    }
  }
}