package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

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