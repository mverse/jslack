package io.mverse.kslack.api.methods.response.channels

import io.mverse.kslack.api.methods.SlackApiResponse

data class ChannelsUnarchiveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
