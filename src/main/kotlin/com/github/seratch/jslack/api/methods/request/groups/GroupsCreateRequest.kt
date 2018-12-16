package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsCreateRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Name of private channel to create
   */
  val name: String,

  /**
   * Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   */
  val isValidate: Boolean = false): SlackApiRequest