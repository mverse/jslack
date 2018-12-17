package io.mverse.kslack.api.methods.request.chat

import io.mverse.kslack.api.methods.SlackApiRequest

data class ChatMeMessageRequest(

  /**
   * Authentication token. Requires scope: `chat:write:user`
   */
  override var token: String? = null,

  /**
   * Channel to send message to. Can be a public channel, private group or IM channel. Can be an encoded ID, or a name.
   */
  val channel: String? = null,

  /**
   * Text of the message to send.
   */
  val text: String? = null): SlackApiRequest