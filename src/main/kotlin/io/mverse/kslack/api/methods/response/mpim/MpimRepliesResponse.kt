package io.mverse.kslack.api.methods.response.mpim

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Message

data class MpimRepliesResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message>? = null): SlackApiResponse