package io.mverse.kslack.api.methods.response.reactions

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.MessageItem
import io.mverse.kslack.api.model.Paging

data class ReactionsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val items: List<MessageItem>? = null,
    val paging: Paging? = null): SlackApiResponse