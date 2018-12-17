package io.mverse.kslack.api.methods.response.dnd

import io.mverse.kslack.api.methods.SlackApiResponse

data class DndSetSnoozeResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isSnoozeEnabled: Boolean = false,
    val snoozeEndtime: Int? = null,
    val snoozeRemaining: Int? = null): SlackApiResponse