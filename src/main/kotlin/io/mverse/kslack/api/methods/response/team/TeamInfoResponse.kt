package io.mverse.kslack.api.methods.response.team

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Team

data class TeamInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val team: Team? = null): SlackApiResponse