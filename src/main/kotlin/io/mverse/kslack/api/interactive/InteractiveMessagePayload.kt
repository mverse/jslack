package io.mverse.kslack.api.interactive

import io.mverse.kslack.api.model.Action
import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Message
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

data class InteractiveMessagePayload(
    override val type: String,
    val actions: List<Action>,
    val responseUrl: String?,
    val triggerId: String?,
    override val callbackId: String,
    val attachmentId: Long,
    val originalMessage: Message?,
    val name: String?,
    val value: String?,
    override val team: Team,
    override val user: User,
    override val channel: Channel,
    override val actionTs: String?,
    override val messageTs: String?,
    val isAppUnfurl: Boolean,
    val token: String): InteractivePayload