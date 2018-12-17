package io.mverse.kslack.api.methods.request.search

import io.mverse.kslack.api.methods.SlackApiRequest

data class SearchAllRequest(

  /**
   * Authentication token. Requires scope: `search:read`
   */
  val token: String,

  /**
   * Search query. May contains booleans, etc.
   */
  val query: String? = null,

  /**
   * Return matches sorted by either `score` or `timestamp`.
   */
  val sort: String? = null,

  /**
   * Change sort direction to ascending (`asc`) or descending (`desc`).
   */
  val sortDir: String? = null,

  /**
   * Pass a value of `true` to enable query highlight markers (see below).
   */
  val isHighlight: Boolean = false,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest