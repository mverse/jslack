package io.mverse.kslack.api.methods.request.im

import io.mverse.kslack.api.methods.SlackApiRequest

data class ImMarkRequest(

  /**
   * Authentication token. Requires scope: `im:write`
   */
  override var token: String? = null,

  /**
   * Direct message channel to set reading cursor in.
   */
  val channel: String? = null,

  /**
   * Timestamp of the most recently seen message.
   */
  val ts: String? = null): SlackApiRequest