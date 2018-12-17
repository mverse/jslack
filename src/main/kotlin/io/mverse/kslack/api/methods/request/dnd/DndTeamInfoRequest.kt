package io.mverse.kslack.api.methods.request.dnd

import io.mverse.kslack.api.methods.SlackApiRequest

data class DndTeamInfoRequest(

  /**
   * Authentication token. Requires scope: `dnd:read`
   */
  override var token: String? = null,

  /**
   * Comma-separated list of users to fetch Do Not Disturb status for
   */
  val users: List<String>? = null): SlackApiRequest