package io.mverse.kslack.api.methods.request.users.profile

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersProfileGetRequest(

  /**
   * Authentication token. Requires scope: `users.profile:read`
   */
  override var token: String? = null,

  /**
   * User to retrieve profile info for
   */
  val user: String? = null,

  /**
   * Include labels for each ID in custom profile fields
   */
  val isIncludeLabels: Boolean = false): SlackApiRequest