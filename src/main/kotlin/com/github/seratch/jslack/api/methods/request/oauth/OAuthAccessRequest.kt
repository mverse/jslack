package com.github.seratch.jslack.api.methods.request.oauth

import com.github.seratch.jslack.api.methods.SlackApiRequest

/**
 * https://api.slack.com/docs/oauth
 */


data class OAuthAccessRequest(

  /**
   * Issued when you created your application.
   */
  val clientId: String? = null,

  /**
   * Issued when you created your application.
   */
  val clientSecret: String? = null,

  /**
   * The `code` param returned via the OAuth callback.
   */
  val code: String? = null,

  /**
   * This must match the originally submitted URI (if one was sent).
   */
  val redirectUri: String? = null,

  /**
   * Request the user to add your app only to a single channel.
   */
  val isSingleChannel: Boolean = false): SlackApiRequest