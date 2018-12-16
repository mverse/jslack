package com.github.seratch.jslack.api.methods.request.chat

import com.github.seratch.jslack.api.methods.SlackApiRequest
import com.github.seratch.jslack.api.model.Attachment

/**
 * https://api.slack.com/methods/chat.postMessage
 */


data class ChatPostMessageRequest(

  /**
   * Authentication token. Requires scope: `chat:write`
   */
  val token: String,

  /**
   * aSet your bot's user name.
   * Must be used in conjunction with `as_user` set to false, otherwise ignored. See [authorship](#authorship) below.
   */
  val username: String? = null,

  /**
   * Provide another message's `ts` value to make this message a reply. Avoid using a reply's `ts` value; use its parent instead.
   */
  val threadTs: String? = null,

  /**
   * Channel, private group, or IM channel to send message to.
   * Can be an encoded ID, or a name. See [below](#channels) for more details.
   */
  val channel: String? = null,

  /**
   * Text of the message to send. See below for an explanation of [formatting](#formatting).
   * This field is usually required, unless you're providing only `attachments` instead.
   */
  val text: String? = null,

  /**
   * Change how messages are treated. Defaults to `none`. See [below](#formatting).
   */
  val parse: String? = null,

  /**
   * Find and link channel names and usernames.
   */
  val isLinkNames: Boolean = false,

  /**
   * A JSON-based array of structured attachments, presented as a URL-encoded string.
   */
  val attachments: List<Attachment>? = null,

  /**
   * Pass true to enable unfurling of primarily text-based content.
   */
  val isUnfurlLinks: Boolean = false,

  /**
   * Pass false to disable unfurling of media content.
   */
  val isUnfurlMedia: Boolean = false,

  /**
   * Pass true to post the message as the authed user, instead of as a bot.
   * Defaults to false. See [authorship](#authorship) below.
   *
   *
   * NOTE: The default value is intentionally null to support workplace apps.
   */
  val asUser: Boolean? = null,

  /**
   * Disable Slack markup parsing by setting to `false`. Enabled by default.
   */
  val isMrkdwn: Boolean = true,

  /**
   * URL to an image to use as the icon for this message.
   * Must be used in conjunction with `as_user` set to false, otherwise ignored. See [authorship](#authorship) below.
   */
  val iconUrl: String? = null,

  /**
   * Emoji to use as the icon for this message. Overrides `icon_url`.
   * Must be used in conjunction with `as_user` set to `false`, otherwise ignored. See [authorship](#authorship) below.
   */
  val iconEmoji: String? = null,

  /**
   * Used in conjunction with `thread_ts` and indicates whether reply should be made visible to
   * everyone in the channel or conversation. Defaults to `false`.
   */
  val isReplyBroadcast: Boolean = false): SlackApiRequest
