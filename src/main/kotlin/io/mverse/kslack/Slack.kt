package io.mverse.kslack

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.call.receive
import io.ktor.http.takeFrom
import io.mverse.kslack.api.methods.MethodsClient
import io.mverse.kslack.api.methods.impl.BaseMethodsClient
import io.mverse.kslack.api.scim.SCIMClient
import io.mverse.kslack.api.scim.SCIMClientImpl
import io.mverse.kslack.api.webhook.Payload
import io.mverse.kslack.api.webhook.WebhookResponse
import io.mverse.kslack.shortcut.Shortcut
import io.mverse.kslack.shortcut.impl.ShortcutImpl
import io.mverse.kslack.shortcut.model.ApiToken

/**
 * Slack Integrations
 *
 *
 * https://{your team name}.slack.com/apps/manage/custom-integrations
 */
data class Slack(val httpClient: HttpClient,
                 val apiToken: ApiToken? = null,
                 val methods: MethodsClient = BaseMethodsClient(httpClient, defaultToken = apiToken),
                 val shortcuts: Shortcut = ShortcutImpl(methods = methods, apiToken = apiToken)) :
    MethodsClient by methods, Shortcut by shortcuts {

  /**
   * Send a data to Incoming Webhook endpoint.
   */
  suspend fun send(url: String, payload: Payload): WebhookResponse {
    val response = httpClient.call {
      body = payload
      this.url.takeFrom(url)
    }
    val body: String = response.receive()
    return WebhookResponse(
        code = response.response.status.value,
        message = response.response.status.description,
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

  fun shortcut(apiToken: ApiToken): Shortcut {
    return ShortcutImpl(apiToken = apiToken, methods = this)
  }

  //  companion object {
  //
  //    @JvmStatic
  //    val instance = Slack(SlackHttpClient())
  //
  //    @JvmStatic
  //    fun getInstance(httpClient: SlackHttpClient): io.mverse.kslack.Slack {
  //      return Slack(httpClient)
  //    }
  //  }
}
