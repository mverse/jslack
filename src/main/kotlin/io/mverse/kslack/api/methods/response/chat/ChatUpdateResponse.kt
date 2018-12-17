package io.mverse.kslack.api.methods.response.chat

import io.mverse.kslack.api.methods.SlackApiResponse

data class ChatUpdateResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: String? = null,
    val ts: String? = null,
    val text: String? = null): SlackApiResponse