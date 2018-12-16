package com.github.seratch.jslack.api.methods.response.im

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.Im
import com.github.seratch.jslack.api.model.ResponseMetadata

data class ImListResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val ims: List<Im>? = null,
    val responseMetadata: ResponseMetadata? = null): SlackApiResponse
