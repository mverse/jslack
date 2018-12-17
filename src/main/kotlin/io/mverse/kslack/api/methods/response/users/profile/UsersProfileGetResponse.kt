package io.mverse.kslack.api.methods.response.users.profile

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.User

data class UsersProfileGetResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val profile: User.Profile? = null): SlackApiResponse