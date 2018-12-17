package io.mverse.kslack.api.methods.response.mpim

import io.mverse.kslack.api.methods.SlackApiResponse

data class MpimMarkResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse