package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersLookupByEmailRequest(

  /**
   * Authentication token. Requires scope: `users:read.email`
   */
  val token: String,

  /**
   * An email address belonging to a user in the workspace
   */
  val email: String? = null): SlackApiRequest