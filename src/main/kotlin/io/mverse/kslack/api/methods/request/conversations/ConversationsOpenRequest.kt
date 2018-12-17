package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsOpenRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  override var token: String? = null,

  /**
   * Resume a conversation by supplying an `im` or `mpim`'s ID. Or provide the `users` field instead.
   */
  val channel: String? = null,

  /**
   * Boolean, indicates you want the full IM channel definition in the response.
   */
  val isReturnIm: Boolean = false,

  /**
   * Comma separated lists of users. If only one user is included, this creates a 1:1 DM.
   * The ordering of the users is preserved whenever a multi-person direct message is returned.
   * Supply a `channel` when not supplying `users`.
   */
  val users: List<String>? = null): SlackApiRequest
