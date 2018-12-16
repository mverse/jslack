package com.github.seratch.jslack.api.methods.request.chat

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ChatDeleteRequest(

  /**
   * Authentication token. Requires scope: `chat:write`
   */
  val token: String,

  /**
   * Timestamp of the message to be deleted.
   */
  val ts: String? = null,

  /**
   * Channel containing the message to be deleted.
   */
  val channel: String? = null,

  /**
   * Pass true to delete the message as the authed user with `chat:write:user` scope.
   * [Bot users](/bot-users) in this context are considered authed users.
   * If unused or false, the message will be deleted with `chat:write:bot` scope.
   */
  val isAsUser: Boolean = false): SlackApiRequest