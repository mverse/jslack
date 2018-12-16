package com.github.seratch.jslack.api.methods.response.reactions

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Message

data class ReactionsGetResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val type: String? = null,
    val channel: String? = null,
    val message: Message? = null): SlackApiResponse