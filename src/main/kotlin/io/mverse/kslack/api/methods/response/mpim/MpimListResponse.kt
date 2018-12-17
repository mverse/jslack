package io.mverse.kslack.api.methods.response.mpim

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Group

data class MpimListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val groups: List<Group>? = null): SlackApiResponse