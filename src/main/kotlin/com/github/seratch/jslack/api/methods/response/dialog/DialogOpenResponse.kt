package com.github.seratch.jslack.api.methods.response.dialog

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.dialog.DialogResponseMetadata

data class DialogOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,
    val responseMetadata: DialogResponseMetadata? = null): SlackApiResponse
