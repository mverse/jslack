package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsLeaveRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  override var token: String? = null,

  /**
   * Conversation to leave
   */
  val channel: String? = null): SlackApiRequest
