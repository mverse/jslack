package io.mverse.kslack.api.methods.response.dnd

import io.mverse.kslack.api.methods.SlackApiResponse

data class DndEndDndResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse