package io.mverse.kslack.api.methods.response.users

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.User

data class UsersInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val user: User? = null): SlackApiResponse