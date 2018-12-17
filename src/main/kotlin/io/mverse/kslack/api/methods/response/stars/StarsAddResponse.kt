package io.mverse.kslack.api.methods.response.stars

import io.mverse.kslack.api.methods.SlackApiResponse

data class StarsAddResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse