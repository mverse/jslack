package com.github.seratch.jslack.api.methods.response.reminders

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class RemindersDeleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse