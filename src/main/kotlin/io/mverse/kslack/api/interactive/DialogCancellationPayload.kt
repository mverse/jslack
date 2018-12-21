package io.mverse.kslack.api.interactive

import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

/**
 * Sent by slack when the user cancels a dialog box
 */
data class DialogCancellationPayload(
    override val type: String,
    val responseUrl: String?,
    override val callbackId: String,
    override val team: Team,
    override val user: User,
    override val channel: Channel,
    override val actionTs: String?,
    override val messageTs: String?,
    val token: String) : InteractivePayload