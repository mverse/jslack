package com.github.seratch.jslack.api.methods.response.stars

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class StarsRemoveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse