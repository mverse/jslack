package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.bots.BotsInfoRequest
import com.github.seratch.jslack.api.methods.response.bots.Bot
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_bots_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun botsInfo() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val bot = "BEMFSS0A1" // hard coded
    val response = slack.methods().botsInfo(BotsInfoRequest(token=token, bot=bot))
    assertThat(response.toString(), response.ok, `is`(true))
    assertThat<Bot>(response.toString(), response.bot, `is`(notNullValue()))
  }
}