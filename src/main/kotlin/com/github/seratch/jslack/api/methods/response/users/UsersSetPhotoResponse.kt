package com.github.seratch.jslack.api.methods.response.users

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.User

data class UsersSetPhotoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val profile: User.Profile? = null): SlackApiResponse
