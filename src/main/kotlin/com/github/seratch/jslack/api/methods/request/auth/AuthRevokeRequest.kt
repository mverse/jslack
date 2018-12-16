package com.github.seratch.jslack.api.methods.request.auth

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class AuthRevokeRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  val token: String,

  /**
   * Setting this parameter to `1` triggers a _testing mode_ where the specified token will not actually be revoked.
   */
  val isTest: Boolean = false): SlackApiRequest