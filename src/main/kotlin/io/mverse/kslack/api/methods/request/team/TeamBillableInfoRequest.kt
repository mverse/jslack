package io.mverse.kslack.api.methods.request.team

import io.mverse.kslack.api.methods.SlackApiRequest

data class TeamBillableInfoRequest(

  /**
   * Authentication token. Requires scope: `admin`
   */
  override var token: String? = null,

  /**
   * A user to retrieve the billable information for. Defaults to all users.
   */
  val user: String? = null): SlackApiRequest