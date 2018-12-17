package io.mverse.kslack.api.methods.response.groups

import io.mverse.kslack.api.methods.SlackApiResponse
import com.google.gson.annotations.SerializedName

data class GroupsRenameResponse(
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,
    val channel: RenamedChannel? = null) : SlackApiResponse

data class RenamedChannel(
    val id: String? = null,
    @SerializedName("is_group")
    val isGroup: Boolean = false,
    val name: String? = null,
    val created: Int? = null)