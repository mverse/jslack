package io.mverse.kslack.api.methods.response.oauth

import io.mverse.kslack.api.methods.SlackApiResponse

data class OAuthAccessResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val accessToken: String? = null,
    val scope: String? = null,
    val teamName: String? = null,
    val teamId: String? = null,
    val userId: String? = null,
    val incomingWebhook: IncomingWebhook? = null,
    val bot: Bot? = null) : SlackApiResponse {

  data class IncomingWebhook(
      val url: String? = null,
      val channel: String? = null,
      val channelId: String? = null,
      val configurationUrl: String? = null)

  class Bot(
      val botUserId: String? = null,
      val botAccessToken: String? = null)
}
