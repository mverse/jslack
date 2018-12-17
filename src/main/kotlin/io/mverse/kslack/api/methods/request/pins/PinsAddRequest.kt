package io.mverse.kslack.api.methods.request.pins

import io.mverse.kslack.api.methods.SlackApiRequest

data class PinsAddRequest(

  /**
   * Authentication token. Requires scope: `pins:write`
   */
  val token: String,

  /**
   * Channel to pin the item in.
   */
  val channel: String? = null,

  /**
   * File to pin.
   */
  val file: String? = null,

  /**
   * File comment to pin.
   */
  val fileComment: String? = null,

  /**
   * Timestamp of the message to pin.
   */
  val timestamp: String? = null): SlackApiRequest