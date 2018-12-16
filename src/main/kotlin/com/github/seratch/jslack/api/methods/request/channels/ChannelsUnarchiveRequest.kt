package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChannelsUnarchiveRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * Channel to unarchive
   */
  val channel: String? = null): SlackApiRequest