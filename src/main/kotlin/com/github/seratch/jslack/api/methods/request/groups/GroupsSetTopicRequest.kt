package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsSetTopicRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  val token: String,

  /**
   * The new topic
   */
  val channel: String? = null,

  /**
   * Private channel to set the topic of
   */
  val topic: String? = null): SlackApiRequest