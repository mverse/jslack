package io.mverse.kslack.api.methods.response.channels

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Channel

data class ChannelsInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: Channel? = null): SlackApiResponse
