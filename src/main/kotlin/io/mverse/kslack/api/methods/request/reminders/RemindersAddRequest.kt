package io.mverse.kslack.api.methods.request.reminders

import io.mverse.kslack.api.methods.SlackApiRequest

data class RemindersAddRequest(

  /**
   * Authentication token. Requires scope: `reminders:write`
   */
  override var token: String? = null,

  /**
   * The content of the reminder
   */
  val text: String? = null,

  /**
   * When this reminder should happen: the Unix timestamp (up to five years from now),
   * the number of seconds until the reminder (if within 24 hours), or a natural language description
   * (Ex. \"in 15 minutes,\" or \"every Thursday\")
   */
  val time: String? = null,

  /**
   * The user who will receive the reminder. If no user is specified, the reminder will go to user who created it.
   */
  val user: String? = null): SlackApiRequest