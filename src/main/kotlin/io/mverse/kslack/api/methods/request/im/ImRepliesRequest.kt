package io.mverse.kslack.api.methods.request.im

import io.mverse.kslack.api.methods.SlackApiRequest

data class ImRepliesRequest(

  /**
   * Authentication token. Requires scope: `im:history`
   */
  override var token: String? = null,

  /**
   * Direct message channel to fetch thread from.
   */
  val channel: String? = null,

  /**
   * Unique identifier of a thread's parent message.
   */
  val threadTs: String? = null): SlackApiRequest