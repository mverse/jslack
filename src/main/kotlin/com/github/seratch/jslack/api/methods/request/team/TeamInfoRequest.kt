package com.github.seratch.jslack.api.methods.request.team

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class TeamInfoRequest(

  /**
   * Authentication token. Requires scope: `team:read`
   */
  val token: String): SlackApiRequest