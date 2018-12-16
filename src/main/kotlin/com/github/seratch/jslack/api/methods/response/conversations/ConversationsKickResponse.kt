package com.github.seratch.jslack.api.methods.response.conversations

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ConversationsKickResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
