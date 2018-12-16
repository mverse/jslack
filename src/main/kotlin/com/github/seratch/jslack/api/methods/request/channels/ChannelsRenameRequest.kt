package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChannelsRenameRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * Channel to rename
   */
  val channel: String,

  /**
   * New name for channel.
   */
  val name: String,

  /**
   * Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   */
  val isValidate: Boolean = false): SlackApiRequest