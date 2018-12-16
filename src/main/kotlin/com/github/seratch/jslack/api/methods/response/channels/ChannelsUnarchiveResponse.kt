package com.github.seratch.jslack.api.methods.response.channels

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ChannelsUnarchiveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
