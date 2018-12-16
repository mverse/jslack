package com.github.seratch.jslack.api.methods.request.usergroups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsergroupsListRequest(

  /**
   * Authentication token. Requires scope: `usergroups:read
   */
  val token: String,

  /**
   * Include disabled User Groups.
   */
  val isIncludeDisabled: Boolean = false,

  /**
   * Include the number of users in each User Group
   */
  val isIncludeCount: Boolean = false,

  /**
   * Include the list of users for each User Group.
   */
  val isIncludeUsers: Boolean = false): SlackApiRequest