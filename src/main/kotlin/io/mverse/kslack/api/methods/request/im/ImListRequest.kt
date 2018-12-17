package io.mverse.kslack.api.methods.request.im

import io.mverse.kslack.api.methods.SlackApiRequest

data class ImListRequest(

  /**
   * Authentication token. Requires scope: `im:read`
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
  val limit: Int? = null): SlackApiRequest