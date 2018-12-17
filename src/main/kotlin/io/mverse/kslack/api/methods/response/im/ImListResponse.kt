package io.mverse.kslack.api.methods.response.im

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.Im
import io.mverse.kslack.api.model.ResponseMetadata

data class ImListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val ims: List<Im>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
