package com.github.seratch.jslack.api.methods.response.rtm

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Channel
import com.github.seratch.jslack.api.model.Group
import com.github.seratch.jslack.api.model.Im
import com.github.seratch.jslack.api.model.Team
import com.github.seratch.jslack.api.model.User

/**
 * @see [rtm.start](https://api.slack.com/methods/rtm.start)
 */

data class RTMStartResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val url: String? = null,
    val self: User? = null,
    val team: Team? = null,
    val users: List<User>? = null,
    val channels: List<Channel>? = null,
    val groups: List<Group>? = null,
    val ims: List<Im>? = null): SlackApiResponse
