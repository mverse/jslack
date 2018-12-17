package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

data class ChannelsRepliesRequest(
  /**
   * Authentication token. Requires scope: `channels:history`
   */
  override var token: String? = null,

  /**
   * Channel to fetch thread from
   */
  val channel: String? = null,

  /**
   * Unique identifier of a thread's parent message
   */
  val threadTs: String? = null): SlackApiRequest
