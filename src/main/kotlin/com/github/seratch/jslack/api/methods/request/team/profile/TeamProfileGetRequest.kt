package com.github.seratch.jslack.api.methods.request.team.profile

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class TeamProfileGetRequest(

  /**
   * Authentication token. Requires scope: `users.profile:read`
   */
  val token: String,

  /**
   * Filter by visibility.
   */
  val visibility: String? = null): SlackApiRequest