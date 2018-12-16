package com.github.seratch.jslack.api.methods.response.groups

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class GroupsKickResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse