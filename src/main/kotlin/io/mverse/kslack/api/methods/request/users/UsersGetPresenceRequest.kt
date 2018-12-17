package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersGetPresenceRequest(

  /**
   * Authentication token. Requires scope: `users:read`
   */
  override var token: String? = null,

  /**
   * User to get presence info on. Defaults to the authed user.
   */
  val user: String? = null): SlackApiRequest