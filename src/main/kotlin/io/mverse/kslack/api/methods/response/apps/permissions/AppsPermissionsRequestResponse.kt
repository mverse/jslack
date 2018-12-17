package io.mverse.kslack.api.methods.response.apps.permissions

import io.mverse.kslack.api.methods.SlackApiResponse

data class AppsPermissionsRequestResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse