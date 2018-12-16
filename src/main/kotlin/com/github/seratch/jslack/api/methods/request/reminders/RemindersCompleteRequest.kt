package com.github.seratch.jslack.api.methods.request.reminders

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class RemindersCompleteRequest(

  /**
   * Authentication token. Requires scope: `reminders:write`
   */
  val token: String,

  /**
   * The ID of the reminder to be marked as complete
   */
  val reminder: String? = null): SlackApiRequest