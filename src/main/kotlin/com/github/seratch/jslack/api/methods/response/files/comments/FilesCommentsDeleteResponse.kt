package com.github.seratch.jslack.api.methods.response.files.comments

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class FilesCommentsDeleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse