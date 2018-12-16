package com.github.seratch.jslack.api.methods.request.stars

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class StarsListRequest(

  /**
   * Authentication token. Requires scope: `stars:read`
   */
  val token: String,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest