package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsKickRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
 override var token: String? = null,

  /**
   * User to remove from channel.
   */
 val channel: String? = null,

  /**
   * Channel to remove user from.
   */
 val user: String? = null) : SlackApiRequest