package com.github.seratch.jslack.api.methods.request.channels

import com.github.seratch.jslack.api.methods.SlackApiRequest

class ChannelsSetTopicRequest(

  /**
   * Authentication token. Requires scope: `channels:write`
   */
  val token: String,

  /**
   * Channel to set the topic of
   */
  val channel: String? = null,

  /**
   * The new topic
   */
  val topic: String? = null): SlackApiRequest