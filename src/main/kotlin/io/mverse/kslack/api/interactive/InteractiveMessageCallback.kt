package io.mverse.kslack.api.interactive

import com.google.gson.annotations.SerializedName
import io.mverse.kslack.api.model.Action
import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Message
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

data class InteractiveMessageCallback(
    val type: Type,
    val actions: List<Action>,
    val responseUrl: String?,
    val triggerId: String?,
    val callbackId: String,
    val attachmentId: Long,
    val originalMessage: Message?,
    val team: Team,
    val user: User,
    val channel: Channel,
    val name: String?,
    val value: String?,
    val actionTs: String?,
    val messageTs: String?,
    val isAppUnfurl: Boolean,
    val token: String) {

  enum class Type {
    @SerializedName("interactive_message") INTERACTIVE_MESSAGE;

    override fun toString() = name.toLowerCase()
  }
}
