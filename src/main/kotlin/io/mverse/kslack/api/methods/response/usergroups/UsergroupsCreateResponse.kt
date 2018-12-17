package io.mverse.kslack.api.methods.response.usergroups

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Usergroup

data class UsergroupsCreateResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val usergroup: Usergroup? = null): SlackApiResponse