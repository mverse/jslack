package io.mverse.kslack.api.methods.response.users

import io.mverse.kslack.api.methods.SlackApiResponse

data class UsersSetActiveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse