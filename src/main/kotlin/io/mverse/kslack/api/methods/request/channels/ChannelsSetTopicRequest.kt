package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsSetTopicRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  override var token: String? = null,

  /**
   * Channel to set the topic of
   */
  val channel: String? = null,

  /**
   * The new topic
   */
  val topic: String? = null): SlackApiRequest