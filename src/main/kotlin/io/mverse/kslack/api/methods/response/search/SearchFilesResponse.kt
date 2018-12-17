package io.mverse.kslack.api.methods.response.search

import io.mverse.kslack.api.methods.SlackApiResponse
import io.mverse.kslack.api.model.SearchResult

data class SearchFilesResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val query: String? = null,
    val files: SearchResult? = null): SlackApiResponse