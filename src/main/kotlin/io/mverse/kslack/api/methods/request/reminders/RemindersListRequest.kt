package io.mverse.kslack.api.methods.request.reminders

import io.mverse.kslack.api.methods.SlackApiRequest

data class RemindersListRequest(

  /**
   * Authentication token. Requires scope: `reminders:read`
   */
  val token: String): SlackApiRequest