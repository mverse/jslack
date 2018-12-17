package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsSetTopicRequest(

  /**
   * Authentication token. Requires scope: `groups:write`
   */
  override var token: String? = null,

  /**
   * The new topic
   */
  val channel: String? = null,

  /**
   * Private channel to set the topic of
   */
  val topic: String? = null): SlackApiRequest