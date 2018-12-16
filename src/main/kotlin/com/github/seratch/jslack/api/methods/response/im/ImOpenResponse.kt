package com.github.seratch.jslack.api.methods.response.im

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Channel

data class ImOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isNoOp: Boolean = false,
    val isAlreadyOpen: Boolean = false,

    val channel: Channel? = null): SlackApiResponse