package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsRenameRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to rename
   */
  val channel: String? = null,

  /**
   * New name for private channel.
   */
  val name: String,

  /**
   * Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   */
  val isValidate: Boolean = false): SlackApiRequest