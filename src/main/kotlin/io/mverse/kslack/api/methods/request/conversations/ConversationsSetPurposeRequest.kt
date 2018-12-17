package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsSetPurposeRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  override var token: String? = null,

  /**
   * Conversation to set the purpose of
   */
  val channel: String? = null,

  /**
   * A new, specialer purpose
   */
  val purpose: String? = null): SlackApiRequest
