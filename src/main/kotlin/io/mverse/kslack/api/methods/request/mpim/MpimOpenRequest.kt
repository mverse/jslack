package io.mverse.kslack.api.methods.request.mpim

import io.mverse.kslack.api.methods.SlackApiRequest

data class MpimOpenRequest(

  /**
   * Authentication token. Requires scope: `mpim:write`
   */
  val token: String,

  /**
   * Comma separated lists of users.
   * The ordering of the users is preserved whenever a MPIM group is returned.
   */
  val users: List<String>? = null): SlackApiRequest