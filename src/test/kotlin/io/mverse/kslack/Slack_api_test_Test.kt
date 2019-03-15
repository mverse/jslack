package io.mverse.kslack

import io.mverse.kslack.api.methods.request.api.ApiTestRequest
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_api_test_Test {

  internal var slack = io.mverse.kslack.Slack()

  @Test
  fun ok() = runBlocking {
    val response = slack.apiTest(ApiTestRequest(foo = "fine"))
    assertThat(response.ok, `is`(true))
    assertThat<String>(response.args!!.foo, `is`("fine"))
  }

  @Test
  fun error() = runBlocking {
    val response = slack.apiTest(ApiTestRequest(error = ("error")))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("error"))
    assertThat<String>(response.args!!.error, `is`("error"))
  }
}