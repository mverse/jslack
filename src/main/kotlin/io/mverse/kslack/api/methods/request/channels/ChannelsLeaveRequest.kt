package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsLeaveRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
 override var token: String? = null,

  /**
   * Channel to leave
   */
 val channel: String) : SlackApiRequest