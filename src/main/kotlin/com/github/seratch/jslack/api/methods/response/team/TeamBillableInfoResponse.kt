package com.github.seratch.jslack.api.methods.response.team

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.BillableInfo

data class TeamBillableInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val billableInfo: Map<String, BillableInfo>? = null): SlackApiResponse