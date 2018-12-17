package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsCreateChildRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  override var token: String? = null,

  /**
   * Private channel to clone and archive.
   */
  val channel: String? = null): SlackApiRequest