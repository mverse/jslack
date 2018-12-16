package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

class ChannelsJoinRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
 val token: String,

  /**
   * Name of channel to join
   */
 val name: String,

  /**
   * Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   */
 val isValidate: Boolean = false) : SlackApiRequest