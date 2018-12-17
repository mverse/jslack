package io.mverse.kslack.api.methods.response.auth

import io.mverse.kslack.api.methods.SlackApiResponse

data class AuthRevokeResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isRevoked: Boolean = false): SlackApiResponse