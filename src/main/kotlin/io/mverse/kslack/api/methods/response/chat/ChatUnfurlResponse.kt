package io.mverse.kslack.api.methods.response.chat

import io.mverse.kslack.api.methods.SlackApiResponse

data class ChatUnfurlResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse
