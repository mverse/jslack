package com.github.seratch.jslack.api.methods.response.users

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class UsersSetPresenceResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse