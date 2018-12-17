package io.mverse.kslack.api.methods.response.conversations

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.ResponseMetadata

data class ConversationsMembersResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val members: List<String>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
