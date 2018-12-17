package io.mverse.kslack.api.methods.response.chat

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Message

data class ChatPostMessageResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: String? = null,
    val ts: String? = null,
    val message: Message? = null): SlackApiResponse