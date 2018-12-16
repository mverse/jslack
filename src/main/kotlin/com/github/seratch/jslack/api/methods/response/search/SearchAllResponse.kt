package com.github.seratch.jslack.api.methods.response.search

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.github.seratch.jslack.api.model.SearchResult

data class SearchAllResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val query: String? = null,
    val messages: SearchResult? = null,
    val files: SearchResult? = null): SlackApiResponse