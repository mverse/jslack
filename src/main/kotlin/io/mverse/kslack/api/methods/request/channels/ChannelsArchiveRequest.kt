package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

data class ChannelsArchiveRequest(
  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,
  /**
   * Channel to archive
   */
  val channel: String? = null) : SlackApiRequest