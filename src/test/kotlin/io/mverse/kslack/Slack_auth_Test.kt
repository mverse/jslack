package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.auth.AuthRevokeRequest
import io.mverse.kslack.api.methods.request.auth.AuthTestRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_auth_Test {

  internal var slack = io.mverse.kslack.Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun authRevoke() {
    val response = slack.methods().authRevoke(AuthRevokeRequest(token="dummy", isTest= true))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("invalid_auth"))
    assertThat(response.isRevoked, `is`(false))
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun authTest() {
    var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val response = slack.methods().authTest(AuthTestRequest(token = token))
    assertThat(response.ok, `is`(true))
    assertThat<String>(response.url, `is`(notNullValue()))
  }
}