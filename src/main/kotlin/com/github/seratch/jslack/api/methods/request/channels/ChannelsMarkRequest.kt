package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChannelsMarkRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * Private channel to set reading cursor in.
   */
  val channel: String,

  /**
   * Timestamp of the most recently seen message.
   */
  val ts: String): SlackApiRequest