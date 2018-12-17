package io.mverse.kslack.api.methods.request.auth

import io.mverse.kslack.api.methods.SlackApiRequest

data class AuthTestRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  val token: String): SlackApiRequest