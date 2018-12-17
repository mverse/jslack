package io.mverse.kslack.api.methods.response.reactions

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Message

data class ReactionsGetResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val type: String? = null,
    val channel: String? = null,
    val message: Message? = null): SlackApiResponse