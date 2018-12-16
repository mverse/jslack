package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersSetActiveRequest(

  /**
   * Authentication token. Requires scope: `users:write`
   */
  val token: String): SlackApiRequest