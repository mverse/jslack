package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.oauth.OAuthAccessRequest
import io.mverse.kslack.api.methods.request.oauth.OAuthTokenRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_oauth_Test {

  internal var slack = io.mverse.kslack.Slack()

  // TODO: valid test
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun access() {
    run {
      val response = slack.oauthAccess(OAuthAccessRequest(
          clientId = "3485157640.XXXX",
          clientSecret = "XXXXX",
          code = "",
          redirectUri = "http://seratch.net/foo"
      ))
      assertThat(response.ok, `is`(false))
    }
  }

  // TODO: valid test
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun token() {
    run {
      val response = slack.oauthToken(OAuthTokenRequest(
          clientId = "3485157640.XXXX",
          clientSecret = "XXXXX",
          code = "",
          redirectUri = "http://seratch.net/foo"
      ))
      assertThat(response.ok, `is`(false))
    }
  }
}