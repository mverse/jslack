package io.mverse.kslack.api.methods.response.rtm

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Group
import io.mverse.kslack.api.model.Im
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

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
