package io.mverse.kslack.api.methods.response.rtm

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

/**
 * @see [rtm.connect](https://api.slack.com/methods/rtm.connect)
 */

data class RTMConnectResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val url: String? = null,
    val self: User? = null,
    val team: Team? = null): SlackApiResponse
