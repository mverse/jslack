package com.github.seratch.jslack.api.methods.response.pins

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class PinsRemoveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse