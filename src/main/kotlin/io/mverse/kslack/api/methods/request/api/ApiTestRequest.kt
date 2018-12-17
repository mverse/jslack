package io.mverse.kslack.api.methods.request.api

import io.mverse.kslack.api.methods.SlackApiRequest

data class ApiTestRequest(

  /**
   * example property to return
   */
  val foo: String? = null,

  /**
   * Error response to return
   */
  val error: String? = null): SlackApiRequest