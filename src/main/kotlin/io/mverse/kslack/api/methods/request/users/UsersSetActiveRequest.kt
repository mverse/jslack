package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersSetActiveRequest(

  /**
   * Authentication token. Requires scope: `users:write`
   */
  val token: String): SlackApiRequest