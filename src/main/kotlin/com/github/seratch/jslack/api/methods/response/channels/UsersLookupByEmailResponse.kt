package com.github.seratch.jslack.api.methods.response.channels

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.User

data class UsersLookupByEmailResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val user: User? = null): SlackApiResponse
