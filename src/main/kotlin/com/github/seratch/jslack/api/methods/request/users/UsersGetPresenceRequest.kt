package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersGetPresenceRequest(

  /**
   * Authentication token. Requires scope: `users:read`
   */
  val token: String,

  /**
   * User to get presence info on. Defaults to the authed user.
   */
  val user: String? = null): SlackApiRequest