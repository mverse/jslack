package io.mverse.kslack.api.methods.request.apps.permissions

import io.mverse.kslack.api.methods.SlackApiRequest

data class AppsPermissionsInfoRequest(
    /**
     * Authentication token. Requires scope: `none`
     */
    override var token: String? = null) : SlackApiRequest