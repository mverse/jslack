package io.mverse.kslack.api.methods.response.usergroups

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Usergroup

data class UsergroupsListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val usergroups: List<Usergroup>? = null): SlackApiResponse