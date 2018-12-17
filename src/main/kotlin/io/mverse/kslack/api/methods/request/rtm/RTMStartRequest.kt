package io.mverse.kslack.api.methods.request.rtm

import io.mverse.kslack.api.methods.SlackApiRequest

/**
 * @see [rtm.start](https://api.slack.com/methods/rtm.start)
 */


data class RTMStartRequest(

  /**
   * Authentication token. Requires scope: `rtm:stream`
   */
  override var token: String? = null,

  /**
   * Exclude latest timestamps for channels, groups, mpims, and ims. Automatically sets `no_unreads` to `1`
   */
  val isNoLatest: Boolean = false,

  /**
   * Return timestamp only for latest message object of each channel (improves performance).
   */
  val isSimpleLatest: Boolean = false,

  /**
   * Set this to `true` to receive the locale for users and channels. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false,

  /**
   * Only deliver presence events when requested by subscription.
   * See [presence subscriptions](/docs/presence-and-status#subscriptions).
   */
  val isPresenceSub: Boolean = false,

  /**
   * Skip unread counts for each channel (improves performance).
   */
  val isNoUnreads: Boolean = false,

  /**
   * Batch presence deliveries via subscription.
   * Enabling changes the shape of `presence_change` events. See [batch presence](/docs/presence-and-status#batching).
   */
  val isBatchPresenceAware: Boolean = false,

  /**
   * Returns MPIMs to the client in the API response.
   */
  val isMpimAware: Boolean = false): SlackApiRequest