package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsLeaveRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to leave
   */
  val channel: String? = null): SlackApiRequest