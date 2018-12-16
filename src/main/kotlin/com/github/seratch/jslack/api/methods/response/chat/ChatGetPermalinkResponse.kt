package com.github.seratch.jslack.api.methods.response.chat

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ChatGetPermalinkResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: String? = null,
    val permalink: String? = null): SlackApiResponse
