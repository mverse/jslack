package io.mverse.kslack.api.methods.request.chat

import io.mverse.kslack.api.methods.SlackApiRequest
import io.mverse.kslack.api.model.Attachment

data class ChatUpdateRequest(

  /**
   * Authentication token. Requires scope: `chat:write`
   */
  val token: String,

  /**
   * Channel, private group, or IM channel to send message to. Can be an encoded ID, or a name.
   */
  val channel: String? = null,

  /**
   * Timestamp of the message to be updated.
   */
  val ts: String? = null,

  /**
   * Text of the message to send.
   * See below for an explanation of [formatting](#formatting).
   * This field is usually required, unless you're providing only `attachments` instead.
   */
  val text: String? = null,

  /**
   * `id` of the user who will receive the ephemeral message. The user should be in the channel specified by the `channel` argument.
   */
  val user: String? = null,

  /**
   * Pass true to post the message as the authed bot. Defaults to false.
   */
  val isAsUser: Boolean = false,

  /**
   * A JSON-based array of structured attachments, presented as a URL-encoded string.
   */
  val attachments: List<Attachment>? = null,

  /**
   * Find and link channel names and usernames.
   */
  val isLinkNames: Boolean = false,

  /**
   * Change how messages are treated. Defaults to `none`. See [below](#formatting).
   */
  val parse: String? = null): SlackApiRequest