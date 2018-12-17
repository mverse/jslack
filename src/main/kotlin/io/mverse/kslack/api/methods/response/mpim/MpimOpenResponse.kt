package io.mverse.kslack.api.methods.response.mpim

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Group

data class MpimOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val group: Group? = null): SlackApiResponse