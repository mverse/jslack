package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsSetPurposeRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  override var token: String? = null,

  /**
   * Private channel to set the purpose of
   */
  val channel: String? = null,

  /**
   * The new purpose
   */
  val purpose: String? = null): SlackApiRequest