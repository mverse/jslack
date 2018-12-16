package com.github.seratch.jslack.api.methods.request.im

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ImMarkRequest(

  /**
   * Authentication token. Requires scope: `im:write`
   */
  val token: String,

  /**
   * Direct message channel to set reading cursor in.
   */
  val channel: String? = null,

  /**
   * Timestamp of the most recently seen message.
   */
  val ts: String? = null): SlackApiRequest