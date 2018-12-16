package com.github.seratch.jslack.api.methods.response.mpim

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Message

data class MpimHistoryResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val latest: String? = null,
    val messages: List<Message>? = null,
    val isHasMore: Boolean = false): SlackApiResponse