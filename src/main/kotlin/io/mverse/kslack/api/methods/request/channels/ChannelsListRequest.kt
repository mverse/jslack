package io.mverse.kslack.api.methods.request.channels

import io.mverse.kslack.api.methods.SlackApiRequest

class ChannelsListRequest(

  /**
   * Authentication token. Requires scope: `channels:read`
   */
 override var token: String? = null,

  /**
   * Exclude the `members` collection from each `channel`
   */
 val isExcludeMembers: Boolean = false,

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
   * Exclude archived channels from the list
   */
 val isExcludeArchived: Boolean = false) : SlackApiRequest