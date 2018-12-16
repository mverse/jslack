package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.emoji.EmojiListRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_emoji_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun emoji() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    run {
      val response = slack.methods().emojiList(EmojiListRequest(token))
      assertThat(response.ok, `is`(true))
      assertThat<Map<String, String>>(response.emoji, `is`(notNullValue()))
    }
  }
}