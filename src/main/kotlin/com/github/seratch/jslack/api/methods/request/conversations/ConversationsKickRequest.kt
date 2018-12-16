package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsKickRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * ID of conversation to remove user from.
   */
  val channel: String? = null,

  /**
   * User ID to be removed.
   */
  val user: String? = null): SlackApiRequest
