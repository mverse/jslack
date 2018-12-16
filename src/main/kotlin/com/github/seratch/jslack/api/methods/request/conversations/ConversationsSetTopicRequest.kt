package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsSetTopicRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * Conversation to set the topic of
   */
  val channel: String? = null,

  /**
   * The new topic string. Does not support formatting or linkification.
   */
  val topic: String? = null): SlackApiRequest
