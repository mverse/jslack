package io.mverse.kslack.api.methods.request.search

import io.mverse.kslack.api.methods.SlackApiRequest

data class SearchMessagesRequest(

  /**
   * Authentication token. Requires scope: `search:read`
   */
  override var token: String? = null,

  /**
   * Change sort direction to ascending (`asc`) or descending (`desc`).
   */
  val sortDir: String? = null,

  /**
   * Search query. May contain booleans, etc.
   */
  val query: String? = null,

  /**
   * Return matches sorted by either `score` or `timestamp`.
   */
  val sort: String? = null,

  /**
   * Pass a value of `true` to enable query highlight markers (see below).
   */
  val isHighlight: Boolean = false,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest