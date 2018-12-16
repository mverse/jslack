package com.github.seratch.jslack.api.methods.request.dnd

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class DndInfoRequest(

  /**
   * Authentication token. Requires scope: `dnd:read`
   */
  val token: String,

  /**
   * User to fetch status for (defaults to current user)
   */
  val user: String? = null): SlackApiRequest