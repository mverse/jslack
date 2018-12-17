package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsJoinRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * ID of conversation to join
   */
  val channel: String? = null): SlackApiRequest
