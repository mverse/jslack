package com.github.seratch.jslack.api.methods.response.users

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.ResponseMetadata
import com.github.seratch.jslack.api.model.User

data class UsersListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val members: List<User>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
