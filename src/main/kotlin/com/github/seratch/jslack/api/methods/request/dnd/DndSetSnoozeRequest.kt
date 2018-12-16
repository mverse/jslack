package com.github.seratch.jslack.api.methods.request.dnd

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class DndSetSnoozeRequest(

  /**
   * Authentication token. Requires scope: `dnd:write`
   */
  val token: String,

  /**
   * Number of minutes, from now, to snooze until.
   */
  val numMinutes: Int? = null): SlackApiRequest