package io.mverse.kslack.api.methods.response.im

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Message

data class ImHistoryResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val latest: String? = null,
    val messages: List<Message>? = null,
    val isHasMore: Boolean = false): SlackApiResponse