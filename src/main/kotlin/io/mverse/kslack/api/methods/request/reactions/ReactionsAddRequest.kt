package io.mverse.kslack.api.methods.request.reactions

import io.mverse.kslack.api.methods.SlackApiRequest

data class ReactionsAddRequest(

  /**
   * Authentication token. Requires scope: `reactions:write`
   */
  override var token: String? = null,

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