package com.github.seratch.jslack.api.methods.response.files

import com.github.seratch.jslack.api.methods.SlackApiResponse

data class FilesDeleteResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null): SlackApiResponse