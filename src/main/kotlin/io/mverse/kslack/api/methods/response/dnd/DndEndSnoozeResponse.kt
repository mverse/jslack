package io.mverse.kslack.api.methods.response.dnd

import io.mverse.kslack.api.methods.SlackApiResponse

data class DndEndSnoozeResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isDndEnabled: Boolean = false,
    val nextDndStartTs: Int? = null,
    val nextDndEndTs: Int? = null,
    val isSnoozeEnabled: Boolean = false): SlackApiResponse