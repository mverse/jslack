package com.github.seratch.jslack.api.model

data class SearchResult(
  val total: Int? = null,
  val paging: Paging? = null,
  val matches: List<MatchedItem>? = null)
