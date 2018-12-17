package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsKickRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  override var token: String? = null,

  /**
   * ID of conversation to remove user from.
   */
  val channel: String? = null,

  /**
   * User ID to be removed.
   */
  val user: String? = null): SlackApiRequest
