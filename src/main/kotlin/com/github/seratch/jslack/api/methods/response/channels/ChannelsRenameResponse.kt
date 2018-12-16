package com.github.seratch.jslack.api.methods.response.channels

import com.github.seratch.jslack.api.methods.SlackApiResponse
import com.google.gson.annotations.SerializedName

data class ChannelsRenameResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    val channel: RenamedChannel? = null) : SlackApiResponse {

  data class RenamedChannel(
      val id: String? = null,
      @SerializedName("is_channel")
      val isChannel: Boolean = false,
      val name: String? = null,
      val created: Int = 0)
}
