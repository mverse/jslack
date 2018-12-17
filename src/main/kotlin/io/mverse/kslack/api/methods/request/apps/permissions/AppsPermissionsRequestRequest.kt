package io.mverse.kslack.api.methods.request.apps.permissions

import io.mverse.kslack.api.methods.SlackApiRequest

data class AppsPermissionsRequestRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  override var token: String? = null,

  /**
   * Token used to trigger the permissions API
   */
  val triggerId: String? = null,

  /**
   * A comma separated list of scopes to request for
   */
  val scopes: List<String>? = null): SlackApiRequest