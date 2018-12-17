package io.mverse.kslack.api.methods.request.auth

import io.mverse.kslack.api.methods.SlackApiRequest

data class AuthRevokeRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  override var token: String? = null,

  /**
   * Setting this parameter to `1` triggers a _testing mode_ where the specified token will not actually be revoked.
   */
  val isTest: Boolean = false): SlackApiRequest