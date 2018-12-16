package com.github.seratch.jslack.api.methods.request.auth

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class AuthTestRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  val token: String): SlackApiRequest