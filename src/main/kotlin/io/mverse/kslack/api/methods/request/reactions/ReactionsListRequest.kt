package io.mverse.kslack.api.methods.request.reactions

import io.mverse.kslack.api.methods.SlackApiRequest

data class ReactionsListRequest(

  /**
   * Authentication token. Requires scope: `reactions:read`
   */
  val token: String,

  /**
   * Show reactions made by this user. Defaults to the authed user.
   */
  val user: String? = null,

  /**
   * If true always return the complete reaction list.
   */
  val isFull: Boolean = false,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest