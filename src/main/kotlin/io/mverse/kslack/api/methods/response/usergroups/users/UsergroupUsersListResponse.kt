package io.mverse.kslack.api.methods.response.usergroups.users

import io.mverse.kslack.api.methods.SlackApiResponse

data class UsergroupUsersListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val users: List<String>? = null): SlackApiResponse