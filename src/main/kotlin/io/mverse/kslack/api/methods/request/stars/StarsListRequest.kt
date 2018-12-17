package io.mverse.kslack.api.methods.request.stars

import io.mverse.kslack.api.methods.SlackApiRequest

data class StarsListRequest(

  /**
   * Authentication token. Requires scope: `stars:read`
   */
  override var token: String? = null,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest