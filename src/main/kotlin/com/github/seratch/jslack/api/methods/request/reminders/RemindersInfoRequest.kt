package com.github.seratch.jslack.api.methods.request.reminders

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class RemindersInfoRequest(

  /**
   * Authentication token. Requires scope: `reminders:read`
   */
  val token: String,

  /**
   * The ID of the reminder
   */
  val reminder: String? = null): SlackApiRequest