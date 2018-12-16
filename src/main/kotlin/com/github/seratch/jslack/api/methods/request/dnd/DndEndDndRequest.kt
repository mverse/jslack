package com.github.seratch.jslack.api.methods.request.dnd

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class DndEndDndRequest(

  /**
   * Authentication token. Requires scope: `dnd:write`
   */
  val token: String): SlackApiRequest