package io.mverse.kslack.api.methods.request.reminders

import io.mverse.kslack.api.methods.SlackApiRequest

data class RemindersCompleteRequest(

  /**
   * Authentication token. Requires scope: `reminders:write`
   */
  val token: String,

  /**
   * The ID of the reminder to be marked as complete
   */
  val reminder: String? = null): SlackApiRequest