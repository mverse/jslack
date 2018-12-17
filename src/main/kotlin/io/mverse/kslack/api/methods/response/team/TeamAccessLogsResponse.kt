package io.mverse.kslack.api.methods.response.team

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Login
import io.mverse.kslack.api.model.Paging

data class TeamAccessLogsResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val logins: List<Login>? = null,
    val paging: Paging? = null): SlackApiResponse