package com.github.seratch.jslack.api.methods.response.files

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.File
import com.github.seratch.jslack.api.model.Paging

data class FilesListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val files: List<File> = listOf(),
    val paging: Paging? = null): SlackApiResponse