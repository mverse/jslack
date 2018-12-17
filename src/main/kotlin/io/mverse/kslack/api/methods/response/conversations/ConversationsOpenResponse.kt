package io.mverse.kslack.api.methods.response.conversations

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Conversation

data class ConversationsOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isNoOp: Boolean = false,
    val isAlreadyOpen: Boolean = false,
    val channel: Conversation? = null): SlackApiResponse
