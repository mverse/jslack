package com.github.seratch.jslack.api.methods.response.team.profile

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Team

data class TeamProfileGetResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val profile: Profiles? = null) : SlackApiResponse {

  data class Profiles(val fields: List<Team.Profile>? = null)
}