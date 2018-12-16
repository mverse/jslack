package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersListRequest(

  /**
   * Authentication token. Requires scope: `users:read`
   */
  val token: String,

  /**
   * Paginate through collections of data by setting the `cursor` parameter to a `next_cursor` attribute
   * returned by a previous request's `response_metadata`.
   * Default value fetches the first \"page\" of the collection. See [pagination](/docs/pagination) for more detail.
   */
  val cursor: String? = null,

  /**
   * The maximum number of items to return.
   * Fewer than the requested number of items may be returned, even if the end of the users list hasn't been reached.
   */
  val limit: Int? = null,

  /**
   * Set this to `true` to receive the locale for users. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false,

  /**
   * Deprecated. Whether to include presence data in the output.
   * Defaults to `false`. Setting this to `true` reduces performance, especially with large teams.
   */

  val isPresence: Boolean = false): SlackApiRequest