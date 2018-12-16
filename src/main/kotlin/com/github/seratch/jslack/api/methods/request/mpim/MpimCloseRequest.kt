package com.github.seratch.jslack.api.methods.request.mpim

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class MpimCloseRequest(

  /**
   * Authentication token. Requires scope: `mpim:write`
   */
  val token: String,

  /**
   * MPIM to close.
   */
  val channel: String? = null): SlackApiRequest