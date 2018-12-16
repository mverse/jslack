package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsSetPurposeRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to set the purpose of
   */
  val channel: String? = null,

  /**
   * The new purpose
   */
  val purpose: String? = null): SlackApiRequest