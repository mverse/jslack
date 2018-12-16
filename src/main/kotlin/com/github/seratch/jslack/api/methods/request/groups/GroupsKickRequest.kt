package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

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