package com.github.seratch.jslack.api.methods.response.im

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ImCloseResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse