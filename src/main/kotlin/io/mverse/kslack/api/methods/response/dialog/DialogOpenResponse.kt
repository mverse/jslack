package io.mverse.kslack.api.methods.response.dialog

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.dialog.DialogResponseMetadata

data class DialogOpenResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,
    val responseMetadata: DialogResponseMetadata? = null): SlackApiResponse
