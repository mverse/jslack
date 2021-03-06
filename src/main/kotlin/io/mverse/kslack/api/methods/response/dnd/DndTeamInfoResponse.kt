package io.mverse.kslack.api.methods.response.dnd

import io.mverse.kslack.api.methods.SlackApiResponse

data class DndTeamInfoResponse(

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    // user.id -> info
    val users: Map<String, DndTeamMemberInfo>? = null) : SlackApiResponse {
  data class DndTeamMemberInfo(
      val isDndEnabled: Boolean = false,
      val nextDndStartTs: Int? = null,
      val nextDndEndTs: Int? = null)
}