package com.github.seratch.jslack.api.methods.request.usergroups.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsergroupUsersUpdateRequest(

  /**
   * Authentication token. Requires scope: `usergroups:write`
   */
  val token: String,

  /**
   * The encoded ID of the User Group to update.
   */
  val usergroup: String? = null,

  /**
   * A comma separated string of encoded user IDs that represent the entire list of users for the User Group.
   */
  val users: List<String>? = null,

  /**
   * Include the number of users in the User Group.
   */
  val isIncludeCount: Boolean = false): SlackApiRequest