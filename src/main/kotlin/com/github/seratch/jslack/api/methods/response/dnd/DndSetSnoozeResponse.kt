package com.github.seratch.jslack.api.methods.response.dnd

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class DndSetSnoozeResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val isSnoozeEnabled: Boolean = false,
    val snoozeEndtime: Int? = null,
    val snoozeRemaining: Int? = null): SlackApiResponse