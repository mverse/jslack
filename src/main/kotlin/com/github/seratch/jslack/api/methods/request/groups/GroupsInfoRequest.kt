package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsInfoRequest(

  /**
   * Authentication token. Requires scope: `groups:read`
   */
  val token: String,

  /**
   * Private channel to get info on
   */
  val channel: String? = null,

  /**
   * Set this to `true` to receive the locale for this group. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false): SlackApiRequest