package com.github.seratch.jslack.api.methods.request.im

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ImRepliesRequest(

  /**
   * Authentication token. Requires scope: `im:history`
   */
  val token: String,

  /**
   * Direct message channel to fetch thread from.
   */
  val channel: String? = null,

  /**
   * Unique identifier of a thread's parent message.
   */
  val threadTs: String? = null): SlackApiRequest