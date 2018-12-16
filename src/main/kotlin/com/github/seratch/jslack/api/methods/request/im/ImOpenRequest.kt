package com.github.seratch.jslack.api.methods.request.im

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class ImOpenRequest(

  /**
   * Authentication token. Requires scope: `im:write`
   */
  val token: String,

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