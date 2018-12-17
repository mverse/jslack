package io.mverse.kslack.api.methods.response.users

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.ResponseMetadata
import io.mverse.kslack.api.model.User

data class UsersListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val members: List<User>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
