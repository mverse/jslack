package com.github.seratch.jslack.api.methods.request.stars

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class StarsRemoveRequest(

  /**
   * Authentication token. Requires scope: `stars:write`
   */
  val token: String,

  /**
   * File to remove star from.
   */
  val file: String? = null,

  /**
   * File comment to remove star from.
   */
  val fileComment: String? = null,

  /**
   * Channel to remove star from, or channel where the message to remove star from was posted (used with `timestamp`).
   */
  val channel: String? = null,

  /**
   * Timestamp of the message to remove star from.
   */
  val timestamp: String? = null): SlackApiRequest