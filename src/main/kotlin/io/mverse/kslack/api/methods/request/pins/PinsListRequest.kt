package io.mverse.kslack.api.methods.request.pins

import io.mverse.kslack.api.methods.SlackApiRequest

data class PinsListRequest(

  /**
   * Authentication token. Requires scope: `pins:read`
   */
  override var token: String? = null,

  /**
   * Channel to get pinned items for.
   */
  val channel: String? = null): SlackApiRequest