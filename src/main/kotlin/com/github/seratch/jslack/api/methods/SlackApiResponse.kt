package com.github.seratch.jslack.api.methods

interface SlackApiResponse {
  val ok: Boolean
  val warning: String?
  val error: String?
}
