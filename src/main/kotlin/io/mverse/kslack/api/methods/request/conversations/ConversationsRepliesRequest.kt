package io.mverse.kslack.api.methods.request.conversations

import io.mverse.kslack.api.methods.SlackApiRequest

data class ConversationsRepliesRequest(

  /**
   * Authentication token. Requires scope: `conversations:history`
   */
  override var token: String? = null,

  /**
   * Include messages with latest or oldest timestamp in results only when either timestamp is specified.
   */
  val isInclusive: Boolean = false,

  /**
   * Unique identifier of a thread's parent message.
   */
  val ts: String? = null,

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
   * Conversation ID to fetch thread from.
   */
  val channel: String? = null,

  /**
   * Start of time range of messages to include in results.
   */
  val oldest: String? = null,

  /**
   * End of time range of messages to include in results.
   */
  val latest: String? = null): SlackApiRequest
