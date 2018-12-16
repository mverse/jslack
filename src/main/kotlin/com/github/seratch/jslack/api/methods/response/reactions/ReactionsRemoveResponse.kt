package com.github.seratch.jslack.api.methods.response.reactions

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ReactionsRemoveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse