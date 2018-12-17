package io.mverse.kslack.api.methods.response.channels

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.ResponseMetadata

data class ChannelsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channels: List<Channel>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
