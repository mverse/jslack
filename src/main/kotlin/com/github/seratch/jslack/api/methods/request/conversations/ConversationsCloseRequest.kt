package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsCloseRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * Conversation to close.
   */
  val channel: String? = null): SlackApiRequest
