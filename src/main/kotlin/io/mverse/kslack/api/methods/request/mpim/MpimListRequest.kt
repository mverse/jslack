package io.mverse.kslack.api.methods.request.mpim

import io.mverse.kslack.api.methods.SlackApiRequest

data class MpimListRequest(

  /**
   * Authentication token. Requires scope: `mpim:read`
   */
  val token: String): SlackApiRequest