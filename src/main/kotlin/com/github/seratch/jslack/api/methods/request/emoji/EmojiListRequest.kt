package com.github.seratch.jslack.api.methods.request.emoji

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class EmojiListRequest(

  /**
   * Authentication token. Requires scope: `emoji:read`
   */
  val token: String): SlackApiRequest