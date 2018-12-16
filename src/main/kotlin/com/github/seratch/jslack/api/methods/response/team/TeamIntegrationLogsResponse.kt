package com.github.seratch.jslack.api.methods.response.team

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.IntegrationLog
import com.github.seratch.jslack.api.model.Paging

data class TeamIntegrationLogsResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val logs: List<IntegrationLog>? = null,
    val paging: Paging? = null): SlackApiResponse