package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsHistoryRequest(

  /**
   * Authentication token. Requires scope: `channels:history`
   */
 val token: String,

  /**
   * Channel to fetch history for.
   */
 val channel: String? = null,

  /**
   * End of time range of messages to include in results.
   */
 val latest: String? = null,

  /**
   * Start of time range of messages to include in results.
   */
 val oldest: String? = null,

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
 val isUnreads: Boolean = false) : SlackApiRequest