package io.mverse.kslack.api.methods.request.mpim

import io.mverse.kslack.api.methods.SlackApiRequest

data class MpimCloseRequest(

  /**
   * Authentication token. Requires scope: `mpim:write`
   */
  override var token: String? = null,

  /**
   * MPIM to close.
   */
  val channel: String? = null): SlackApiRequest