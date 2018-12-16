package com.github.seratch.jslack.api.methods.request.conversations

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ConversationsUnarchiveRequest(

  /**
   * Authentication token. Requires scope: `conversations:write`
   */
  val token: String,

  /**
   * ID of conversation to unarchive
   */
  val channel: String? = null): SlackApiRequest
