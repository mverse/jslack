package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersInfoRequest(

  /**
   * Authentication token. Requires scope: `users:read`
   */
  val token: String,

  /**
   * User to get info on
   */
  val user: String? = null,

  /**
   * Set this to `true` to receive the locale for this user. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false): SlackApiRequest