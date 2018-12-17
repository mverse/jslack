package io.mverse.kslack.api.methods.response.team.profile

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Team

data class TeamProfileGetResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val profile: Profiles? = null) : SlackApiResponse {

  data class Profiles(val fields: List<Team.Profile>? = null)
}