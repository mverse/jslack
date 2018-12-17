package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsCreateRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * Name of the public or private channel to create
   */
  val name: String,

  /**
   * Create a private channel instead of a public one
   */
  val isPrivate: Boolean = false): SlackApiRequest
