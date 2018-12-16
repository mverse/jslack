package com.github.seratch.jslack.api.methods.response.im

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Message

data class ImRepliesResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message.MessageRoot>? = null): SlackApiResponse