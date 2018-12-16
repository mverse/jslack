package com.github.seratch.jslack.api.methods.request.users.profile

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersProfileGetRequest(

  /**
   * Authentication token. Requires scope: `users.profile:read`
   */
  val token: String,

  /**
   * User to retrieve profile info for
   */
  val user: String? = null,

  /**
   * Include labels for each ID in custom profile fields
   */
  val isIncludeLabels: Boolean = false): SlackApiRequest