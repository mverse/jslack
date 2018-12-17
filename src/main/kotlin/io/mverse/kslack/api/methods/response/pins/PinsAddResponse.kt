package io.mverse.kslack.api.methods.response.pins

import io.mverse.kslack.api.methods.SlackApiResponse

data class PinsAddResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse