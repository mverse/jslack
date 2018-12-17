package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

data class Message(

  val type: String? = null,
  val channel: String? = null,
  val user: String? = null,
  val text: String? = null,
  val attachments: List<Attachment>? = null,
  val ts: String? = null,
  val threadTs: String? = null,
  @SerializedName("is_starred")
  val isStarred: Boolean = false,
  val isWibblr: Boolean = false,
  val pinnedTo: List<String>? = null,
  val reactions: List<Reaction>? = null,
  val username: String? = null,
  val subtype: String? = null,
  val botId: String? = null,
  val icons: Icon? = null,
  val file: File? = null,

  // https://api.slack.com/docs/message-link-unfurling
  val isUnfurlLinks: Boolean = false,
  val isUnfurlMedia: Boolean = false,

  @SerializedName("is_thread_broadcast")
  val isThreadBroadcast: Boolean = false,

  // this field exists only when posting the message with "reply_broadcast": true
  val root: MessageRoot? = null) {
  /**
   * The root message information of a "thread_broadcast" message.
   */

  data class MessageRoot(
    val text: String? = null,
    val username: String? = null,
    val botId: String? = null,
    val isMrkdwn: Boolean = false,
    val type: String? = null,
    val subtype: String? = null,
    val threadTs: String? = null,
    val replyCount: Int? = null,
    val replies: List<MessageRootReply>? = null,
    val isSubscribed: Boolean = false,
    val unreadCount: Int? = null,
    val ts: String? = null)

  /**
   * A reply message information in a MessageRoot.
   */

  data class MessageRootReply(
    val user: String? = null,
    val ts: String? = null)

}
