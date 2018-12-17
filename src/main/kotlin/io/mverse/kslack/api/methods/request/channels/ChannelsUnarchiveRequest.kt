package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

data class ChannelsUnarchiveRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  override var token: String? = null,

  /**
   * Channel to unarchive
   */
  val channel: String? = null): SlackApiRequest