package com.github.seratch.jslack.api.methods.request.apps.permissions

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class AppsPermissionsRequestRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  val token: String,

  /**
   * Token used to trigger the permissions API
   */
  val triggerId: String? = null,

  /**
   * A comma separated list of scopes to request for
   */
  val scopes: List<String>? = null): SlackApiRequest