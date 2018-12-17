package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsInfoRequest(

  /**
   * Authentication token. Requires scope: `channels:read`
   */
 override var token: String? = null,

  /**
   * Set this to `true` to receive the locale for this channel. Defaults to `false`
   */
 val isIncludeLocale: Boolean = false,

  /**
   * Channel to get info on
   */
 val channel: String? = null) : SlackApiRequest