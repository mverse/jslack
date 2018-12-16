package com.github.seratch.jslack.api.methods.response.files

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.File

data class FilesUploadResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val file: File? = null): SlackApiResponse