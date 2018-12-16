package com.github.seratch.jslack.api.methods.response.conversations

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ConversationsArchiveResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
