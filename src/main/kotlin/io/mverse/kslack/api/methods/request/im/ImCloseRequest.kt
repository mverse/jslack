package io.mverse.kslack.api.methods.request.im

import io.mverse.kslack.api.methods.SlackApiRequest

data class ImCloseRequest(

  /**
   * Authentication token. Requires scope: `im:write`
   */
  override var token: String? = null,

  /**
   * Direct message channel to close.
   */
  val channel: String? = null): SlackApiRequest