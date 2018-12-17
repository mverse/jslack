package io.mverse.kslack.api.methods.request.chat

import io.mverse.kslack.api.methods.SlackApiRequest

/**
 * Provide custom unfurl behavior for user-posted URLs
 */


data class ChatUnfurlRequest(

  /**
   * Authentication token. Requires scope: `links:write`
   */
  override var token: String? = null,

  /**
   * Provide a simply-formatted string to send as an ephemeral message to the user
   * as invitation to authenticate further and enable full unfurling behavior
   */
  val userAuthMessage: String? = null,

  /**
   * Set to `true` or `1` to indicate the user must install your Slack app to trigger unfurls for this domain
   */
  val isUserAuthRequired: Boolean = false,

  /**
   * URL-encoded JSON map with keys set to URLs featured in the the message, pointing to their unfurl message attachments.
   */
  val unfurls: String? = null,

  /**
   * Timestamp of the message to add unfurl behavior to.
   */
  val ts: String? = null,

  /**
   * Send users to this custom URL where they will complete authentication in your app to fully trigger unfurling.
   * Value should be properly URL-encoded.
   */
  val userAuthUrl: String? = null,

  /**
   * Channel ID of the message
   */
  val channel: String? = null): SlackApiRequest
