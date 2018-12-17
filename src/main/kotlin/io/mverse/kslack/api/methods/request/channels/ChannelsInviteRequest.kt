package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

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