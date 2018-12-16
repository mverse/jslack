package com.github.seratch.jslack.api.methods.request.reminders

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class RemindersDeleteRequest(

  /**
   * Authentication token. Requires scope: `reminders:write`
   */
  val token: String,

  /**
   * The ID of the reminder
   */
  val reminder: String? = null): SlackApiRequest