package io.mverse.kslack.api.methods.response.files

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.File
import io.mverse.kslack.api.model.FileComment
import io.mverse.kslack.api.model.Paging

data class FilesSharedPublicURLResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val file: File? = null,
    val comments: List<FileComment>? = null,
    val paging: Paging? = null): SlackApiResponse