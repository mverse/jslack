package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsSetPurposeRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * Channel to set the purpose of
   */
  val channel: String? = null,

  /**
   * The new purpose
   */
  val purpose: String? = null): SlackApiRequest
