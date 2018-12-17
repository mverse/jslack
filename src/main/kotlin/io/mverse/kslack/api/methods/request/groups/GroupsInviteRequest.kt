package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsInviteRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to invite user to.
   */
  val channel: String? = null,

  /**
   * User to invite.
   */
  val user: String? = null): SlackApiRequest