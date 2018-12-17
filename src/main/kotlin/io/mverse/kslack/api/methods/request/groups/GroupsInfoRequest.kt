package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsInfoRequest(

  /**
   * Authentication token. Requires scope: `groups:read`
   */
  override var token: String? = null,

  /**
   * Private channel to get info on
   */
  val channel: String? = null,

  /**
   * Set this to `true` to receive the locale for this group. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false): SlackApiRequest