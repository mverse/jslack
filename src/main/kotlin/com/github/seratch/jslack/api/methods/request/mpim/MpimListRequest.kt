package com.github.seratch.jslack.api.methods.request.mpim

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class MpimListRequest(

  /**
   * Authentication token. Requires scope: `mpim:read`
   */
  val token: String): SlackApiRequest