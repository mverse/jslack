package com.github.seratch.jslack.api.webhook

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class WebhookResponse(
  val code: Int? = null,
  val message: String? = null,
  val body: String? = null)
