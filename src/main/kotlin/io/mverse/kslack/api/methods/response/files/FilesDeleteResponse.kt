package io.mverse.kslack.api.methods.response.files

import io.mverse.kslack.api.methods.SlackApiResponse

data class FilesDeleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse