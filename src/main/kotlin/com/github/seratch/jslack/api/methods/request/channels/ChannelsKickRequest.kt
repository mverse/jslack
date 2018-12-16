package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

class ChannelsKickRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
 val token: String,

  /**
   * User to remove from channel.
   */
 val channel: String? = null,

  /**
   * Channel to remove user from.
   */
 val user: String? = null) : SlackApiRequest