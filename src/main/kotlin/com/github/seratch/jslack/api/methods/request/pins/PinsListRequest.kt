package com.github.seratch.jslack.api.methods.request.pins

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class PinsListRequest(

  /**
   * Authentication token. Requires scope: `pins:read`
   */
  val token: String,

  /**
   * Channel to get pinned items for.
   */
  val channel: String? = null): SlackApiRequest