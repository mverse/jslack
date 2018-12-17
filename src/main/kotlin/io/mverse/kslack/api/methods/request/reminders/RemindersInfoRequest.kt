package io.mverse.kslack.api.methods.request.reminders

import io.mverse.kslack.api.methods.SlackApiRequest

data class RemindersInfoRequest(

  /**
   * Authentication token. Requires scope: `reminders:read`
   */
  val token: String,

  /**
   * The ID of the reminder
   */
  val reminder: String? = null): SlackApiRequest