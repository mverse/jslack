package com.github.seratch.jslack.api.methods.response.mpim

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class MpimCloseResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse