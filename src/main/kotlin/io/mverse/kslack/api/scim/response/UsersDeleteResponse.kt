package io.mverse.kslack.api.scim.response

import io.mverse.kslack.api.methods.SlackApiResponse

data class UsersDeleteResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
