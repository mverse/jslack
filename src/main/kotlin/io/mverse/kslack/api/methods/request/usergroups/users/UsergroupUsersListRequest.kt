package io.mverse.kslack.api.methods.request.usergroups.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsergroupUsersListRequest(

  /**
   * Authentication token. Requires scope: `usergroups:read`
   */
  override var token: String? = null,

  /**
   * The encoded ID of the User Group to update.
   */
  val usergroup: String? = null,

  /**
   * Allow results that involve disabled User Groups.
   */
  val isIncludeDisabled: Boolean = false): SlackApiRequest