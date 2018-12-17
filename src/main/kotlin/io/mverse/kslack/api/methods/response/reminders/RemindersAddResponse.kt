package io.mverse.kslack.api.methods.response.reminders

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Reminder

data class RemindersAddResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val reminder: Reminder? = null): SlackApiResponse