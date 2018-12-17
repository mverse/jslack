package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.apps.permissions.AppsPermissionsInfoRequest
import io.mverse.kslack.api.methods.request.apps.permissions.AppsPermissionsRequestRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_apps_Test {

  internal var slack = io.mverse.kslack.Slack.instance

  // TODO: valid test
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun appsPermissionsRequest() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val response = slack.methods().appsPermissionsRequest(AppsPermissionsRequestRequest(
        token = token,
        triggerId = "dummy"))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("not_allowed_token_type"))
  }

  // TODO: valid test
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun appsPermissionsInfo() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val response = slack.methods().appsPermissionsInfo(AppsPermissionsInfoRequest(token))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("not_allowed_token_type"))
  }
}