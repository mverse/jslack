package io.mverse.kslack.api.methods.response.pins

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.MessageItem

data class PinsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val items: List<MessageItem>? = null): SlackApiResponse