package io.mverse.kslack.api.methods.response.api

import io.mverse.kslack.api.methods.SlackApiResponse

data class ApiTestResponse(
    override val ok: Boolean = false,
    val args: Args? = null,
    override val warning: String? = null,
    override val error: String? = null) : SlackApiResponse {
  data class Args(
      val foo: String? = null,
      val error: String? = null)
}