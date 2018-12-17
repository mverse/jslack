package io.mverse.kslack.api.methods

interface SlackApiResponse {
  val ok: Boolean
  val warning: String?
  val error: String?
}
