package com.github.seratch.jslack.api.methods.response.mpim

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Group

data class MpimOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val group: Group? = null): SlackApiResponse