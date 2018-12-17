package io.mverse.kslack.api.methods.response.conversations

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Message
import io.mverse.kslack.api.model.ResponseMetadata

data class ConversationsRepliesResponse (
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message>? = null,
    val isHasMore: Boolean = false,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
