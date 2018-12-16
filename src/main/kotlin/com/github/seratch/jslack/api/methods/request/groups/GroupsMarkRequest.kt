package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsMarkRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to set reading cursor in.
   */
  val channel: String? = null,

  /**
   * Timestamp of the most recently seen message.
   */
  val ts: String? = null): SlackApiRequest