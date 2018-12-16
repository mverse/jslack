package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersSetPresenceRequest(

  /**
   * Authentication token. Requires scope: `users:write`
   */
  val token: String,

  /**
   * Either `auto` or `away`
   */
  val presence: String? = null): SlackApiRequest