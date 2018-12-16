package com.github.seratch.jslack.api.methods.request.team

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class TeamBillableInfoRequest(

  /**
   * Authentication token. Requires scope: `admin`
   */
  val token: String,

  /**
   * A user to retrieve the billable information for. Defaults to all users.
   */
  val user: String? = null): SlackApiRequest