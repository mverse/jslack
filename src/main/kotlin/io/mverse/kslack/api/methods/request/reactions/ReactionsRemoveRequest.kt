package io.mverse.kslack.api.methods.request.reactions

import io.mverse.kslack.api.methods.SlackApiRequest

data class ReactionsRemoveRequest(

  /**
   * Authentication token. Requires scope: `reactions:write`
   */
  val token: String,

  /**
   * Reaction (emoji) name.
   */
  val name: String,

  /**
   * File to remove reaction from.
   */
  val file: String? = null,

  /**
   * File comment to remove reaction from.
   */
  val fileComment: String? = null,

  /**
   * Channel where the message to remove reaction from was posted.
   */
  val channel: String? = null,

  /**
   * Timestamp of the message to remove reaction from.
   */
  val timestamp: String? = null): SlackApiRequest