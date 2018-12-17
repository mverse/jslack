package io.mverse.kslack.api.methods.request.usergroups

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsergroupsDisableRequest(

  /**
   * Authentication token. Requires scope: `usergroups:write`
   */
  override var token: String? = null,

  /**
   * The encoded ID of the User Group to disable.
   */
  val usergroup: String? = null,

  /**
   * Include the number of users in the User Group.
   */
  val isIncludeCount: Boolean = false): SlackApiRequest