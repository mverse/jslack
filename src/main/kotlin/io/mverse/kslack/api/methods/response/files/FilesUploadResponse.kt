package io.mverse.kslack.api.methods.response.files

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.File

data class FilesUploadResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val file: File? = null): SlackApiResponse