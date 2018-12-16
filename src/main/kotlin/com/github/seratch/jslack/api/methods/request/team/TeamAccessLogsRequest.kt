package com.github.seratch.jslack.api.methods.request.team

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class TeamAccessLogsRequest(

  /**
   * Authentication token. Requires scope: `admin`
   */
  val token: String,

  /**
   * End of time range of logs to include in results (inclusive).
   */
  val before: Int? = null,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest