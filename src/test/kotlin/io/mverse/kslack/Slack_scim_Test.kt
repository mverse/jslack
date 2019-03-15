package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.scim.request.UsersDeleteRequest
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test
import java.io.IOException

@Ignore
class Slack_scim_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Ignore
  @Test
  fun deleteUserTest() = runBlocking {
    val userId = "1"
    try {
      val (isOk) = slack.scim().delete(
          UsersDeleteRequest(
              token = token,
              id = userId
          ))

      // testing with an SCIM activated account
      assertThat(isOk, `is`(true))
    } catch (apiError: SlackApiException) {
      assertThat(apiError.responseBody, `is`(notNullValue()))
      assertThat(apiError.error, `is`(nullValue()))
    }
  }
}
