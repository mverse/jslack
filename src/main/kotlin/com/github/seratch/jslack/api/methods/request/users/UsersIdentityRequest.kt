package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersIdentityRequest(

  /**
   * Authentication token. Requires scope: `identity.basic`
   */
  val token: String): SlackApiRequest