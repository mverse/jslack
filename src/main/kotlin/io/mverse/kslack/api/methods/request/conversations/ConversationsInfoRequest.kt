package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsInfoRequest(

  /**
   * Authentication token. Requires scope: `conversations:read`
   */
  override var token: String? = null,

  /**
   * Conversation ID to learn more about
   */
  val channel: String? = null,

  /**
   * Set this to `true` to receive the locale for this conversation. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false): SlackApiRequest