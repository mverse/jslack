package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsRepliesRequest(

  /**
   * Authentication token. Requires scope: `groups:history`
   */
  val token: String,

  /**
   * Private channel to fetch thread from
   */
  val channel: String? = null,

  /**
   * Unique identifier of a thread's parent message
   */
  val threadTs: String? = null): SlackApiRequest