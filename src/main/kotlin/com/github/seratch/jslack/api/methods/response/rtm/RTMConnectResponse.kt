package com.github.seratch.jslack.api.methods.response.rtm

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Team
import com.github.seratch.jslack.api.model.User

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
