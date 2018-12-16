package com.github.seratch.jslack.api.methods.request.apps.permissions

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class AppsPermissionsInfoRequest(
    /**
     * Authentication token. Requires scope: `none`
     */
    val token: String) : SlackApiRequest