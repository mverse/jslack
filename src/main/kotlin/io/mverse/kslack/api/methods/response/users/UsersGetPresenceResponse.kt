package io.mverse.kslack.api.methods.response.users

import io.mverse.kslack.api.methods.SlackApiResponse

data class UsersGetPresenceResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val presence: String? = null,
    val isOnline: Boolean = false,
    val isAutoAway: Boolean = false,
    val isManualAway: Boolean = false,
    val connectionCount: Int? = null,
    val lastActivity: Int? = null): SlackApiResponse