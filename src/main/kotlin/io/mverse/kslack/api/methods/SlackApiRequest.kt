package io.mverse.kslack.api.methods

/**
 * A marker interface for Slack API request objects.
 */
interface SlackApiRequest {
  /**
   * The api token to be used.  Can be left null and the framework will fill in a default if one is available.
   */
  var token: String?
}
