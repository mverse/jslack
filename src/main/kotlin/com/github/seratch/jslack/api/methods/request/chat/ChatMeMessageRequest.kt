package com.github.seratch.jslack.api.methods.request.chat

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChatMeMessageRequest(

  /**
   * Authentication token. Requires scope: `chat:write:user`
   */
  val token: String,

  /**
   * Channel to send message to. Can be a public channel, private group or IM channel. Can be an encoded ID, or a name.
   */
  val channel: String? = null,

  /**
   * Text of the message to send.
   */
  val text: String? = null): SlackApiRequest