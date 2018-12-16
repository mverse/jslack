package com.github.seratch.jslack.api.methods.response.groups

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Group

data class GroupsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val groups: List<Group>? = null): SlackApiResponse