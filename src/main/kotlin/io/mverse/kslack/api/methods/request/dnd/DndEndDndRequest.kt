package io.mverse.kslack.api.methods.request.dnd

import io.mverse.kslack.api.methods.SlackApiRequest

data class DndEndDndRequest(

  /**
   * Authentication token. Requires scope: `dnd:write`
   */
  override var token: String? = null): SlackApiRequest