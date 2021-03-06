package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

data class ChannelsMarkRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  override var token: String? = null,

  /**
   * Private channel to set reading cursor in.
   */
  val channel: String,

  /**
   * Timestamp of the most recently seen message.
   */
  val ts: String): SlackApiRequest