package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsLeaveRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * Conversation to leave
   */
  val channel: String? = null): SlackApiRequest
