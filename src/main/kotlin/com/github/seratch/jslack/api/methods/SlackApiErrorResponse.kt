package com.github.seratch.jslack.api.methods

data class SlackApiErrorResponse(
    override val ok: Boolean = false,
    override val warning: String,
    override val error: String): SlackApiResponse
