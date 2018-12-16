package com.github.seratch.jslack.api.methods.request.usergroups.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsergroupUsersListRequest(

  /**
   * Authentication token. Requires scope: `usergroups:read`
   */
  val token: String,

  /**
   * The encoded ID of the User Group to update.
   */
  val usergroup: String? = null,

  /**
   * Allow results that involve disabled User Groups.
   */
  val isIncludeDisabled: Boolean = false): SlackApiRequest