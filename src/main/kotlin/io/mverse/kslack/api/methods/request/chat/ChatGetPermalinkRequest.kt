package io.mverse.kslack.api.methods.request.chat

import io.mverse.kslack.api.methods.SlackApiRequest

/**
 * A request to retrieve a permalink URL for a specific extant message
 *
 * @see [Slack chat.getPermalink API](https://api.slack.com/methods/chat.getPermalink)
 */


data class ChatGetPermalinkRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  val token: String,

  /**
   * The ID of the conversation or channel containing the message
   */
  val channel: String? = null,

  /**
   * A message's `ts` value, uniquely identifying it within a channel
   */
  val messageTs: String? = null): SlackApiRequest
