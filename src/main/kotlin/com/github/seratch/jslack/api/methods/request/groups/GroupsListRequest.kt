package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsListRequest(

  /**
   * Authentication token. Requires scope: `groups:read`
   */
  val token: String,

  /**
   * Exclude the `members` from each `group`
   */
  val isExcludeMembers: Boolean = false,

  /**
   * Don't return archived private channels.
   */
  val isExcludeArchived: Boolean = false): SlackApiRequest