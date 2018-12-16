package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsOpenRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to open.
   */
  val channel: String? = null): SlackApiRequest