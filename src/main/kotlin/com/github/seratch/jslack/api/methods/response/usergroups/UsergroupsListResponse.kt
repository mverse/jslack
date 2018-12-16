package com.github.seratch.jslack.api.methods.response.usergroups

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Usergroup

data class UsergroupsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val usergroups: List<Usergroup>? = null): SlackApiResponse