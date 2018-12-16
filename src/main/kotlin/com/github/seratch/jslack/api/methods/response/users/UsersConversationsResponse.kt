package com.github.seratch.jslack.api.methods.response.users

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Conversation
import com.github.seratch.jslack.api.model.ResponseMetadata

data class UsersConversationsResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channels: List<Conversation>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
