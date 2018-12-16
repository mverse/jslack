package com.github.seratch.jslack.api.methods.response.chat

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class ChatDeleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: String? = null,
    val ts: String? = null): SlackApiResponse