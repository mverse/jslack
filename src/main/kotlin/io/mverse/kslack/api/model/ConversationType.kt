package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * Represents a type of conversation such as a public channel or IM.
 *
 * @see [Conversations.list API](https://api.slack.com/methods/conversations.list)
 */
enum class ConversationType(private val value: String) {
  @SerializedName("public_channel") PUBLIC_CHANNEL("public_channel"),
  @SerializedName("private_channel") PRIVATE_CHANNEL("private_channel"),
  @SerializedName("mpim") MPIM("mpim"),
  @SerializedName("im") IM("im");

  fun value(): String = value
}
