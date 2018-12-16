package com.github.seratch.jslack.api.methods.response.conversations

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.ResponseMetadata

data class ConversationsMembersResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val members: List<String>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
