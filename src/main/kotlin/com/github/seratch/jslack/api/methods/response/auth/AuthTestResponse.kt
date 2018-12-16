package com.github.seratch.jslack.api.methods.response.auth

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class AuthTestResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val url: String? = null,
    val team: String? = null,
    val user: String? = null,
    val teamId: String? = null,
    val userId: String? = null): SlackApiResponse