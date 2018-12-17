package io.mverse.kslack.api.methods

data class SlackApiErrorResponse(
    override val ok: Boolean = false,
    override val warning: String,
    override val error: String): io.mverse.kslack.api.methods.SlackApiResponse
