package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsSetPurposeRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * Conversation to set the purpose of
   */
  val channel: String? = null,

  /**
   * A new, specialer purpose
   */
  val purpose: String? = null): SlackApiRequest
