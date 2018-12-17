package io.mverse.kslack.api.methods.response.emoji

import io.mverse.kslack.api.methods.SlackApiResponse

data class EmojiListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val emoji: Map<String, String>? = null): SlackApiResponse