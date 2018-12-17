package io.mverse.kslack.api.methods.request.bots

import io.mverse.kslack.api.methods.SlackApiRequest

data class BotsInfoRequest(

  /**
   * Authentication token. Requires scope: `users:read`
   */
  override var token: String? = null,

  /**
   * Bot user to get info on
   */
  val bot: String? = null): SlackApiRequest