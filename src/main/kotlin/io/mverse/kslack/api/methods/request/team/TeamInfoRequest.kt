package io.mverse.kslack.api.methods.request.team

import io.mverse.kslack.api.methods.SlackApiRequest

data class TeamInfoRequest(

  /**
   * Authentication token. Requires scope: `team:read`
   */
  val token: String): SlackApiRequest