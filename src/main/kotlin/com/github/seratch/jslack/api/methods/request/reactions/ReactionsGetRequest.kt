package com.github.seratch.jslack.api.methods.request.reactions

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ReactionsGetRequest(

  /**
   * Authentication token. Requires scope: `reactions:read`
   */
  val token: String,

  /**
   * File to get reactions for.
   */
  val file: String? = null,

  /**
   * File comment to get reactions for.
   */
  val fileComment: String? = null,

  /**
   * Channel where the message to get reactions for was posted.
   */
  val channel: String? = null,

  /**
   * Timestamp of the message to get reactions for.
   */
  val timestamp: String? = null,

  /**
   * If true always return the complete reaction list.
   */
  val isFull: Boolean = false): SlackApiRequest