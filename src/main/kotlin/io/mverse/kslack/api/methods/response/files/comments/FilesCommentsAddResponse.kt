package io.mverse.kslack.api.methods.response.files.comments

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.FileComment

data class FilesCommentsAddResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val comment: FileComment? = null): SlackApiResponse