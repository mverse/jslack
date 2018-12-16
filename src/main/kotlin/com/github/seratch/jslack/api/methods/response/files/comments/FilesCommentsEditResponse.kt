package com.github.seratch.jslack.api.methods.response.files.comments

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.FileComment

data class FilesCommentsEditResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val comment: FileComment? = null): SlackApiResponse