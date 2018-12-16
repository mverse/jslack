package com.github.seratch.jslack.api.methods.request.reminders

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class RemindersListRequest(

  /**
   * Authentication token. Requires scope: `reminders:read`
   */
  val token: String): SlackApiRequest