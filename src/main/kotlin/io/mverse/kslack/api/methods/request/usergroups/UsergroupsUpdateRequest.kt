package io.mverse.kslack.api.methods.request.usergroups

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsergroupsUpdateRequest(

  /**
   * Authentication token. Requires scope: `usergroups:write`
   */
  override var token: String? = null,

  /**
   * The encoded ID of the User Group to update.
   */
  val usergroup: String? = null,

  /**
   * A name for the User Group. Must be unique among User Groups.
   */
  val name: String,

  /**
   * A mention handle. Must be unique among channels, users and User Groups.
   */
  val handle: String? = null,

  /**
   * A short description of the User Group.
   */
  val description: String? = null,

  /**
   * A comma separated string of encoded channel IDs for which the User Group uses as a default.
   */
  val channels: List<String>? = null,

  /**
   * Include the number of users in the User Group.
   */
  val isIncludeCount: Boolean = false): SlackApiRequest