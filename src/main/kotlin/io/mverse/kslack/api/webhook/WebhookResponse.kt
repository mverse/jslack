package io.mverse.kslack.api.webhook

import io.mverse.kslack.api.methods.SlackApiResponse

data class WebhookResponse(
  val code: Int? = null,
  val message: String? = null,
  val body: String? = null)
