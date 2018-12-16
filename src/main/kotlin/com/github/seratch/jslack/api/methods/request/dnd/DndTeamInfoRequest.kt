package com.github.seratch.jslack.api.methods.request.dnd

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class DndTeamInfoRequest(

  /**
   * Authentication token. Requires scope: `dnd:read`
   */
  val token: String,

  /**
   * Comma-separated list of users to fetch Do Not Disturb status for
   */
  val users: List<String>? = null): SlackApiRequest