package io.mverse.kslack.api.methods.request.dnd

import io.mverse.kslack.api.methods.SlackApiRequest

data class DndInfoRequest(

  /**
   * Authentication token. Requires scope: `dnd:read`
   */
  val token: String,

  /**
   * User to fetch status for (defaults to current user)
   */
  val user: String? = null): SlackApiRequest