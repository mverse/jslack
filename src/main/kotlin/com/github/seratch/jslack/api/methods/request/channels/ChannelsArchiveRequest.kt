package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChannelsArchiveRequest(
  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,
  /**
   * Channel to archive
   */
  val channel: String? = null) : SlackApiRequest