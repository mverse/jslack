package com.github.seratch.jslack.api.methods.response.groups

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Message
import com.github.seratch.jslack.api.model.ThreadInfo

data class GroupsRepliesResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val messages: List<Message>? = null,
    val threadInfo: ThreadInfo? = null): SlackApiResponse
