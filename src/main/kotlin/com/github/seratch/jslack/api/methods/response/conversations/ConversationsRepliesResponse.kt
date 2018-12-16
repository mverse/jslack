package com.github.seratch.jslack.api.methods.response.conversations

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Message
import com.github.seratch.jslack.api.model.ResponseMetadata

data class ConversationsRepliesResponse (
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message>? = null,
    val isHasMore: Boolean = false,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
