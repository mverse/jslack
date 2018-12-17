package io.mverse.kslack.api.methods.request.usergroups

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsergroupsListRequest(

  /**
   * Authentication token. Requires scope: `usergroups:read
   */
  override var token: String? = null,

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