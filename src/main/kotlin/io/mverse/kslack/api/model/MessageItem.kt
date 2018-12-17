package io.mverse.kslack.api.model

data class MessageItem(

  val type: String? = null,
  val channel: String? = null,
  val message: Message? = null,
  val file: File? = null,
  val comment: FileComment? = null,
  val created: Int? = null)
