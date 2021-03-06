package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsJoinRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
 override var token: String? = null,

  /**
   * Name of channel to join
   */
 val name: String,

  /**
   * Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   */
 val isValidate: Boolean = false) : SlackApiRequest