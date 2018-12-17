package io.mverse.kslack.api.methods.response.files.comments

import io.mverse.kslack.api.methods.SlackApiResponse

data class FilesCommentsDeleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse