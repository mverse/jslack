package com.github.seratch.jslack.api.methods.request.api

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ApiTestRequest(

  /**
   * example property to return
   */
  val foo: String? = null,

  /**
   * Error response to return
   */
  val error: String? = null): SlackApiRequest