package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsInviteRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * The ID of the public or private channel to invite user(s) to.
   */
  val channel: String? = null,

  /**
   * A comma separated list of user IDs. Up to 30 users may be listed.
   */
  val users: List<String>? = null): SlackApiRequest
