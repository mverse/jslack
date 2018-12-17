package io.mverse.kslack.api.methods.response.files

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.File
import io.mverse.kslack.api.model.Paging

data class FilesListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val files: List<File> = listOf(),
    val paging: Paging? = null): SlackApiResponse