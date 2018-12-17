package io.mverse.kslack.api.methods.request.im

import io.mverse.kslack.api.methods.SlackApiRequest

data class ImHistoryRequest(

  /**
   * Authentication token. Requires scope: `im:history`
   */
  val token: String,

  /**
   * Direct message channel to fetch history for.
   */
  val channel: String? = null,

  /**
   * Start of time range of messages to include in results.
   */
  val oldest: String? = null,

  /**
   * End of time range of messages to include in results.
   */
  val latest: String? = null,

  /**
   * Include messages with latest or oldest timestamp in results.
   */
  val isInclusive: Boolean = false,

  /**
   * Number of messages to return, between 1 and 1000.
   */
  val count: Int? = null,

  /**
   * Include `unread_count_display` in the output?
   */
  val isUnreads: Boolean = false): SlackApiRequest