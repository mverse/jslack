package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.MethodsClient
import com.github.seratch.jslack.api.methods.impl.MethodsClientImpl
import com.github.seratch.jslack.api.scim.SCIMClient
import com.github.seratch.jslack.api.scim.SCIMClientImpl
import com.github.seratch.jslack.api.webhook.Payload
import com.github.seratch.jslack.api.webhook.WebhookResponse
import com.github.seratch.jslack.common.http.SlackHttpClient
import com.github.seratch.jslack.shortcut.Shortcut
import com.github.seratch.jslack.shortcut.impl.ShortcutImpl
import com.github.seratch.jslack.shortcut.model.ApiToken

/**
 * Slack Integrations
 *
 *
 * https://{your team name}.slack.com/apps/manage/custom-integrations
 */
data class Slack(private val httpClient: SlackHttpClient = SlackHttpClient()) {
  /**
   * Send a data to Incoming Webhook endpoint.
   */

  fun send(url: String, payload: Payload): WebhookResponse {
    val httpResponse = this.httpClient.postJsonPostRequest(url, payload)
    val body = httpResponse.body()!!.string()
    SlackHttpClient.debugLog(httpResponse, body)

    return WebhookResponse(
        code = httpResponse.code(),
        message = httpResponse.message(),
        body = body)
  }

  //  /**
  //   * Creates an RTM API client.
  //   */
  //
  //  fun rtm(apiToken: String): RTMClient {
  //    return rtmConnect(apiToken)
  //  }
  //
  //  /**
  //   * Creates an RTM API client using `/rtm.connect`.
  //   */
  //
  //  fun rtmConnect(apiToken: String): RTMClient {
  //    try {
  //      val response = methods().rtmConnect(RTMConnectRequest(token = apiToken))
  //      return if (response.isOk) {
  //        RTMClient(response.url)
  //      } else {
  //        throw IllegalStateException("Failed to the RTM endpoint URL (error: " + response.error + ")")
  //      }
  //    } catch (e: SlackApiException) {
  //      throw IllegalStateException("Couldn't fetch RTM API WebSocket endpoint. Ensure the apiToken value.")
  //    } catch (e: URISyntaxException) {
  //      throw IllegalStateException("Couldn't fetch RTM API WebSocket endpoint. Ensure the apiToken value.")
  //    }
  //  }
  //
  //  /**
  //   * Creates an RTM API client using `/rtm.start`.
  //   */
  //
  //  fun rtmStart(apiToken: String): RTMClient {
  //    try {
  //      val response = methods().rtmStart(RTMStartRequest(token = apiToken))
  //      return if (response.isOk) {
  //        RTMClient(response.url)
  //      } else {
  //        throw IllegalStateException("Failed to the RTM endpoint URL (error: " + response.error + ")")
  //      }
  //    } catch (e: SlackApiException) {
  //      throw IllegalStateException("Couldn't fetch RTM API WebSocket endpoint. Ensure the apiToken value.")
  //    } catch (e: URISyntaxException) {
  //      throw IllegalStateException("Couldn't fetch RTM API WebSocket endpoint. Ensure the apiToken value.")
  //    }
  //  }

  /**
   * Creates a SCIM api client.
   */
  fun scim(): SCIMClient {
    return SCIMClientImpl(httpClient)
  }

  /**
   * Creates a Methods API client.
   */
  fun methods(): MethodsClient {
    return MethodsClientImpl(httpClient)
  }

  fun shortcut(): Shortcut {
    return ShortcutImpl(slack = this)
  }

  fun shortcut(apiToken: ApiToken): Shortcut {
    return ShortcutImpl(apiToken = apiToken, slack = this)
  }

  companion object {

    @JvmStatic
    val instance = Slack(SlackHttpClient())

    @JvmStatic
    fun getInstance(httpClient: SlackHttpClient): Slack {
      return Slack(httpClient)
    }
  }
}
