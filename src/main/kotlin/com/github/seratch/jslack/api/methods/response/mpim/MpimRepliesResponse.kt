package com.github.seratch.jslack.api.methods.response.mpim

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Message

data class MpimRepliesResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message>? = null): SlackApiResponse