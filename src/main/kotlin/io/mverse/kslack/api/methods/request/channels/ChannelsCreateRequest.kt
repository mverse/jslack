package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

data class ChannelsCreateRequest(
  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * Name of channel to create
   */
  val name: String,

  /**
   * Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   */
  val isValidate: Boolean = false) : SlackApiRequest