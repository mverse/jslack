package io.mverse.kslack.api.methods.request.stars

import io.mverse.kslack.api.methods.SlackApiRequest

data class StarsAddRequest(

  /**
   * Authentication token. Requires scope: `stars:write`
   */
  val token: String,

  /**
   * File to add star to.
   */
  val file: String? = null,

  /**
   * File comment to add star to.
   */
  val fileComment: String? = null,

  /**
   * Channel to add star to, or channel where the message to add star to was posted (used with `timestamp`).
   */
  val channel: String? = null,

  /**
   * Timestamp of the message to add star to.
   */
  val timestamp: String? = null): SlackApiRequest