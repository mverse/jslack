package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

class ChannelsLeaveRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
 val token: String,

  /**
   * Channel to leave
   */
 val channel: String) : SlackApiRequest