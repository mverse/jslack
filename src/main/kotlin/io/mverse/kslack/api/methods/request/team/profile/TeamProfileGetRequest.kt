package io.mverse.kslack.api.methods.request.team.profile

import io.mverse.kslack.api.methods.SlackApiRequest

data class TeamProfileGetRequest(

  /**
   * Authentication token. Requires scope: `users.profile:read`
   */
  val token: String,

  /**
   * Filter by visibility.
   */
  val visibility: String? = null): SlackApiRequest