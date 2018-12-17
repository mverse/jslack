package io.mverse.kslack.api.methods.response.team

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.BillableInfo

data class TeamBillableInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val billableInfo: Map<String, BillableInfo>? = null): SlackApiResponse