package io.mverse.kslack.api.methods.response.reactions

import io.mverse.kslack.api.methods.SlackApiResponse

data class ReactionsRemoveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse