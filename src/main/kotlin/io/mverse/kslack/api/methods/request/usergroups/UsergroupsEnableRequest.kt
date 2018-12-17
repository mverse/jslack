package io.mverse.kslack.api.methods.request.usergroups

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsergroupsEnableRequest(

  /**
   * Authentication token. Requires scope: `usergroups:write`
   */
  val token: String,

  /**
   * The encoded ID of the User Group to enable.
   */
  val usergroup: String? = null,

  /**
   * Include the number of users in the User Group.
   */
  val isIncludeCount: Boolean = false): SlackApiRequest