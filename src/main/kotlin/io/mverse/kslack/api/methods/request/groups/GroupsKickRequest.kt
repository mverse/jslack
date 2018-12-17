package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsKickRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to remove user from.
   */
  val channel: String? = null,

  /**
   * User to remove from private channel.
   */
  val user: String? = null): SlackApiRequest