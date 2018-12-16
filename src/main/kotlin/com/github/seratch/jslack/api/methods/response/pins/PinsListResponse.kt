package com.github.seratch.jslack.api.methods.response.pins

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.MessageItem

data class PinsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val items: List<MessageItem>? = null): SlackApiResponse