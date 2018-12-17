package io.mverse.kslack.api.methods.request.dnd

import io.mverse.kslack.api.methods.SlackApiRequest

data class DndSetSnoozeRequest(

  /**
   * Authentication token. Requires scope: `dnd:write`
   */
  val token: String,

  /**
   * Number of minutes, from now, to snooze until.
   */
  val numMinutes: Int? = null): SlackApiRequest