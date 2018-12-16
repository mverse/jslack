package com.github.seratch.jslack.api.methods.response.conversations

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Conversation

data class ConversationsRenameResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: Conversation? = null): SlackApiResponse
