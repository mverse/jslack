package io.mverse.kslack.api.methods.request.rtm

import io.mverse.kslack.api.methods.SlackApiRequest

/**
 * @see [rtm.connect](https://api.slack.com/methods/rtm.connect)
 */


data class RTMConnectRequest(

  /**
   * Authentication token. Requires scope: `rtm:stream`
   */
  override var token: String? = null,

  /**
   * Only deliver presence events when requested by subscription.
   * See [presence subscriptions](/docs/presence-and-status#subscriptions).
   */
  val isPresenceSub: Boolean = false,

  /**
   * Batch presence deliveries via subscription.
   * Enabling changes the shape of `presence_change` events. See [batch presence](/docs/presence-and-status#batching).
   */
  val isBatchPresenceAware: Boolean = false): SlackApiRequest