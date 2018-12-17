package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersLookupByEmailRequest(

  /**
   * Authentication token. Requires scope: `users:read.email`
   */
  val token: String,

  /**
   * An email address belonging to a user in the workspace
   */
  val email: String? = null): SlackApiRequest