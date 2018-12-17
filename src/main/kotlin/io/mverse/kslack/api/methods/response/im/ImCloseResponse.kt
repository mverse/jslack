package io.mverse.kslack.api.methods.response.im

import io.mverse.kslack.api.methods.SlackApiResponse

data class ImCloseResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse