package com.github.seratch.jslack.api.scim.response

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class UsersDeleteResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
