package io.mverse.kslack.api.methods.response.team

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.IntegrationLog
import io.mverse.kslack.api.model.Paging

data class TeamIntegrationLogsResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val logs: List<IntegrationLog>? = null,
    val paging: Paging? = null): SlackApiResponse