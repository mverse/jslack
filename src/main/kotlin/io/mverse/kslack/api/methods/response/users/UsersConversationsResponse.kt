package io.mverse.kslack.api.methods.response.users

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Conversation
import io.mverse.kslack.api.model.ResponseMetadata

data class UsersConversationsResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channels: List<Conversation>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
