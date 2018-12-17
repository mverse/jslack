package io.mverse.kslack.api.interactive

import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

data class DialogSubmissionPayload(
    override val type: String,
    val responseUrl: String?,
    val triggerId: String?,
    val callbackId: String,
    val submission: Map<String, Any?> = emptyMap(),
    val team: Team,
    val user: User,
    val channel: Channel,
    val actionTs: String?,
    val messageTs: String?,
    val isAppUnfurl: Boolean,
    val token: String): InteractivePayload