package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsInfoRequest(

  /**
   * Authentication token. Requires scope: `conversations:read`
   */
  val token: String,

  /**
   * Conversation ID to learn more about
   */
  val channel: String? = null,

  /**
   * Set this to `true` to receive the locale for this conversation. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false): SlackApiRequest