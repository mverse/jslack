package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * https://api.slack.com/docs/message-attachments
 */


data class Field(

  /**
   * Shown as a bold heading above the value text. It cannot contain markup and will be escaped for you.
   */
  val title: String? = null,

  /**
   * The text value of the field. It may contain standard message markup (see details below) and must be escaped as normal. May be multi-line.
   * https://api.slack.com/docs/message-attachments#message_formatting
   */
  val value: String? = null,

  /**
   * An optional flag indicating whether the value is short enough to be displayed side-by-side with other values.
   */
  @SerializedName("short")
  val isValueShortEnough: Boolean = false)