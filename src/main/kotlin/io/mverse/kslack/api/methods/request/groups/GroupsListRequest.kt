package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsListRequest(

  /**
   * Authentication token. Requires scope: `groups:read`
   */
  override var token: String? = null,

  /**
   * Exclude the `members` from each `group`
   */
  val isExcludeMembers: Boolean = false,

  /**
   * Don't return archived private channels.
   */
  val isExcludeArchived: Boolean = false): SlackApiRequest