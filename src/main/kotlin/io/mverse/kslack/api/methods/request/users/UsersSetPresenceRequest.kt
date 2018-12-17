package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersSetPresenceRequest(

  /**
   * Authentication token. Requires scope: `users:write`
   */
  override var token: String? = null,

  /**
   * Either `auto` or `away`
   */
  val presence: String? = null): SlackApiRequest