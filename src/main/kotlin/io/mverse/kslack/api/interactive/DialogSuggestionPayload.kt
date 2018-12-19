package io.mverse.kslack.api.interactive

import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

data class DialogSuggestionPayload(
    override val type: String,
    val name: String,
    val value: String,
    val responseUrl: String?,
    val triggerId: String?,
    override val callbackId: String,
    val state: String?,
    override val team: Team,
    override val user: User,
    override val channel: Channel,
    override val actionTs: String?,
    override val messageTs: String?,
    val token: String): InteractivePayload