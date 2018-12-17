package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsRenameRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  override var token: String? = null,

  /**
   * ID of conversation to rename
   */
  val channel: String? = null,

  /**
   * New name for conversation.
   *
   *
   * Conversation names can only contain lowercase letters, numbers, hyphens, and underscores, and must
   * be 21 characters or less. We will validate the submitted channel name and modify it to meet the above
   * criteria. When calling this method, we recommend storing the channel's name value that is returned
   * in the response.
   */
  val name: String): SlackApiRequest