package io.mverse.kslack.api.methods.request.im

import io.mverse.kslack.api.methods.SlackApiRequest

data class ImOpenRequest(

  /**
   * Authentication token. Requires scope: `im:write`
   */
  override var token: String? = null,

  /**
   * User to open a direct message channel with.
   */
  val user: String? = null,

  /**
   * Boolean, indicates you want the full IM channel definition in the response.
   */
  val isReturnIm: Boolean = false,

  /**
   * Set this to `true` to receive the locale for this im. Defaults to `false`
   */
  val isIncludeLocale: Boolean = false): SlackApiRequest