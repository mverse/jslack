package com.github.seratch.jslack.api.methods.request.mpim

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class MpimMarkRequest(

  /**
   * Authentication token. Requires scope: `mpim:write`
   */
  val token: String,

  /**
   * multiparty direct message channel to set reading cursor in.
   */
  val channel: String? = null,

  /**
   * Timestamp of the most recently seen message.
   */
  val ts: String? = null): SlackApiRequest