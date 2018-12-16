package com.github.seratch.jslack.api.methods.response.dnd

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class DndEndDndResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse