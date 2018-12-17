package io.mverse.kslack.api.methods.response.im

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Channel

data class ImOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isNoOp: Boolean = false,
    val isAlreadyOpen: Boolean = false,

    val channel: Channel? = null): SlackApiResponse