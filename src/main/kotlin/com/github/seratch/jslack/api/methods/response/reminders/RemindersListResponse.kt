package com.github.seratch.jslack.api.methods.response.reminders

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Reminder

data class RemindersListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val reminders: List<Reminder>? = null): SlackApiResponse