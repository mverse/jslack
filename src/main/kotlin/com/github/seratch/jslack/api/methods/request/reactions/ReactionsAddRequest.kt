package com.github.seratch.jslack.api.methods.request.reactions

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ReactionsAddRequest(

  /**
   * Authentication token. Requires scope: `reactions:write`
   */
  val token: String,

  /**
   * Reaction (emoji) name.
   */
  val name: String,

  /**
   * File to add reaction to.
   */
  val file: String? = null,

  /**
   * File comment to add reaction to.
   */
  val fileComment: String? = null,

  /**
   * Channel where the message to add reaction to was posted.
   */
  val channel: String? = null,

  /**
   * Timestamp of the message to add reaction to.
   */
  val timestamp: String? = null): SlackApiRequest