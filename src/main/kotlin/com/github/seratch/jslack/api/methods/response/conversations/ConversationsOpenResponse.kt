package com.github.seratch.jslack.api.methods.response.conversations

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Conversation

data class ConversationsOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isNoOp: Boolean = false,
    val isAlreadyOpen: Boolean = false,
    val channel: Conversation? = null): SlackApiResponse
