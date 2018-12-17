package io.mverse.kslack.api.methods.response.reminders

import io.mverse.kslack.api.methods.SlackApiResponse

data class RemindersCompleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse