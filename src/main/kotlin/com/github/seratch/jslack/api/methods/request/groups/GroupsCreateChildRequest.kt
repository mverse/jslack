package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsCreateChildRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to clone and archive.
   */
  val channel: String? = null): SlackApiRequest