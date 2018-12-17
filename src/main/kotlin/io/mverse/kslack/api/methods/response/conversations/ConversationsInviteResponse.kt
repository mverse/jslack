package io.mverse.kslack.api.methods.response.conversations

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Conversation

data class ConversationsInviteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: Conversation? = null): SlackApiResponse
