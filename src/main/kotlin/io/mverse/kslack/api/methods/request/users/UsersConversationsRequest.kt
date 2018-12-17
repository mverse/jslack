package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest
import io.mverse.kslack.api.model.ConversationType

/**
 * List conversations the calling user may access.
 */


data class UsersConversationsRequest(

  /**
   * Authentication token. Requires scope: `conversations:read`
   */
  override var token: String? = null,

  /**
   * Browse conversations by a specific user ID's membership.
   * Non-public channels are restricted to those where the calling user shares membership."
   */
  val user: String? = null,

  /**
   * Paginate through collections of data by setting the `cursor` parameter to
   * a `next_cursor` attribute returned by a previous request's `response_metadata`.
   * Default value fetches the first \"page\" of the collection. See [pagination](/docs/pagination) for more detail.
   */
  val cursor: String? = null,

  /**
   * Set to `true` to exclude archived channels from the list
   */
  val isExcludeArchived: Boolean = false,

  /**
   * The maximum number of items to return. Fewer than the requested number of items may be returned,
   * even if the end of the list hasn't been reached. Must be an integer no larger than 1000.
   */
  val limit: Int? = null,

  /**
   * Mix and match channel types by providing a comma-separated list of
   * any combination of `public_channel`, `private_channel`, `mpim`, `im`
   */
  val types: List<ConversationType>? = null): SlackApiRequest
