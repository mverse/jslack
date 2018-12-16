package com.github.seratch.jslack.api.methods.request.mpim

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class MpimRepliesRequest(

  /**
   * Authentication token. Requires scope: `mpim:history`
   */
  val token: String,

  /**
   * Multiparty direct message channel to fetch thread from.
   */
  val channel: String? = null,

  /**
   * Unique identifier of a thread's parent message.
   */
  val threadTs: String? = null): SlackApiRequest