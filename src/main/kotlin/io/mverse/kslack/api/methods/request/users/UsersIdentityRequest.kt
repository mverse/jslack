package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersIdentityRequest(

  /**
   * Authentication token. Requires scope: `identity.basic`
   */
  val token: String): SlackApiRequest