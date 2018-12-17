package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsCloseRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * Conversation to close.
   */
  val channel: String? = null): SlackApiRequest
