package io.mverse.kslack.api.methods.response.channels

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Message
import io.mverse.kslack.api.model.ThreadInfo

data class ChannelsRepliesResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message>? = null,
    val threadInfo: ThreadInfo? = null): SlackApiResponse
