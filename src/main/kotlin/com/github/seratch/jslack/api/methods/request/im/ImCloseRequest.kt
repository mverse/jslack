package com.github.seratch.jslack.api.methods.request.im

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ImCloseRequest(

  /**
   * Authentication token. Requires scope: `im:write`
   */
  val token: String,

  /**
   * Direct message channel to close.
   */
  val channel: String? = null): SlackApiRequest