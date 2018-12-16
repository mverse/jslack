package com.github.seratch.jslack.api.model

/**
 * https://api.slack.com/methods/reminders.add
 */


data class Reminder(

  val id: String? = null,
  val creator: String? = null,
  val user: String? = null,
  val text: String? = null,
  val isRecurring: Boolean = false,
  val time: Int? = null,
  val completeTs: Int? = null)