package com.github.seratch.jslack.api.methods.response.usergroups.users

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class UsergroupUsersListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val users: List<String>? = null): SlackApiResponse