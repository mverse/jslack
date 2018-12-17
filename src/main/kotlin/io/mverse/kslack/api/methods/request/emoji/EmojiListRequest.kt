package io.mverse.kslack.api.methods.request.emoji

import io.mverse.kslack.api.methods.SlackApiRequest

data class EmojiListRequest(

  /**
   * Authentication token. Requires scope: `emoji:read`
   */
  val token: String): SlackApiRequest