package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.api.ApiTestRequest
import com.github.seratch.jslack.common.http.SlackHttpClient
import okhttp3.OkHttpClient
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy

class Slack_api_test_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun ok() {
    val response = slack.methods().apiTest(ApiTestRequest(foo= "fine"))
    assertThat(response.ok, `is`(true))
    assertThat<String>(response.args!!.foo, `is`("fine"))
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun error() {
    val response = slack.methods().apiTest(ApiTestRequest(error=("error")))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("error"))
    assertThat<String>(response.args!!.error, `is`("error"))
  }

  @Ignore
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun proxy() {
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 8888))
    val okHttpClient = OkHttpClient.Builder().proxy(proxy).build()
    val slackHttpClient = SlackHttpClient(okHttpClient)
    val slack = Slack.getInstance(slackHttpClient)

    val response = slack.methods().apiTest(ApiTestRequest(foo=("proxy?")))
    assertThat(response.ok, `is`(true))
    assertThat<String>(response.args!!.foo, `is`("proxy?"))
  }
}