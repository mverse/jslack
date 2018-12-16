package com.github.seratch.jslack.api.methods.response.apps.permissions

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class AppsPermissionsRequestResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse