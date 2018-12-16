package com.github.seratch.jslack.api.methods.response.channels

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Channel
import com.github.seratch.jslack.api.model.ResponseMetadata

data class ChannelsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channels: List<Channel>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
