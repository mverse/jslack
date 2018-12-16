package com.github.seratch.jslack.api.methods.request.mpim

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class MpimHistoryRequest(

  /**
   * Authentication token. Requires scope: `mpim:history`
   */
  val token: String,

  /**
   * Multiparty direct message to fetch history for.
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
   * Number of messages to return, between 1 and 1000.
   */
  val count: Int? = null,

  /**
   * Include messages with latest or oldest timestamp in results.
   */
  val isInclusive: Boolean = false,

  /**
   * Include `unread_count_display` in the output?
   */
  val isUnreads: Boolean = false): SlackApiRequest