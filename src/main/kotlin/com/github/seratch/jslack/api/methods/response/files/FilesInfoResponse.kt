package com.github.seratch.jslack.api.methods.response.files

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.File
import com.github.seratch.jslack.api.model.FileComment
import com.github.seratch.jslack.api.model.Paging

data class FilesInfoResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val file: File? = null,
    val comments: List<FileComment>? = null,
    val paging: Paging? = null): SlackApiResponse