package io.mverse.kslack.api.methods.request.team.profile

import io.mverse.kslack.api.methods.SlackApiRequest

data class TeamProfileGetRequest(

  /**
   * Authentication token. Requires scope: `users.profile:read`
   */
  override var token: String? = null,

  /**
   * Filter by visibility.
   */
  val visibility: String? = null): SlackApiRequest