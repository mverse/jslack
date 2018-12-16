package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChannelsInviteRequest(
  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * Channel to invite user to.
   */
  val channel: String? = null,

  /**
   * User to invite to channel.
   */
  val user: String? = null) : SlackApiRequest