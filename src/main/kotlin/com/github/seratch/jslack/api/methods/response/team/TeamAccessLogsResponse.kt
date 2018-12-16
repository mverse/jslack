package com.github.seratch.jslack.api.methods.response.team

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Login
import com.github.seratch.jslack.api.model.Paging

data class TeamAccessLogsResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val logins: List<Login>? = null,
    val paging: Paging? = null): SlackApiResponse