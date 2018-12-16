package com.github.seratch.jslack.api.methods.response.team

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Team

data class TeamInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val team: Team? = null): SlackApiResponse