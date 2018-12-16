package com.github.seratch.jslack.api.methods.request.bots

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class BotsInfoRequest(

  /**
   * Authentication token. Requires scope: `users:read`
   */
  val token: String,

  /**
   * Bot user to get info on
   */
  val bot: String? = null): SlackApiRequest