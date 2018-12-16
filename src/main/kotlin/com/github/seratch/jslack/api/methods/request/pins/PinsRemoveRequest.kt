package com.github.seratch.jslack.api.methods.request.pins

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class PinsRemoveRequest(

  /**
   * Authentication token. Requires scope: `pins:write`
   */
  val token: String,

  /**
   * Channel where the item is pinned to.
   */
  val channel: String? = null,

  /**
   * File to un-pin.
   */
  val file: String? = null,

  /**
   * File comment to un-pin.
   */
  val fileComment: String? = null,

  /**
   * Timestamp of the message to un-pin.
   */
  val timestamp: String? = null): SlackApiRequest