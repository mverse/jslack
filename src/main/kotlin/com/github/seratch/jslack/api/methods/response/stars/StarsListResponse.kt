package com.github.seratch.jslack.api.methods.response.stars

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.MessageItem
import com.github.seratch.jslack.api.model.Paging

data class StarsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val items: List<MessageItem>? = null,
    val paging: Paging? = null): SlackApiResponse