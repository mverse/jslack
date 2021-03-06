package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

data class Action(
    val name: String? = null,
    val text: String? = null,
    val style: String? = null,
    val type: Type = Type.BUTTON,
    val value: String? = null,
    val confirm: Confirmation? = null,
    val options: List<Option>? = null,
    val optionGroups: List<OptionGroup>? = null,
    val selectedOptions: List<Option>? = null,
    val dataSource: String? = null,
    val minQueryLength: Int? = null,
    val url: String? = null)

/**
 * Represents the type of action (e.g Message button or message menu)
 *
 * @see [Interaction Types](https://api.slack.com/interactive-messages.interaction_types)
 */
enum class Type(val value: String) {

  /**
   * @see [Message button](https://api.slack.com/docs/message-buttons)
   */
  @SerializedName("button")
  BUTTON("button"),

  /**
   * @see [Message menus](https://api.slack.com/docs/message-menus)
   */
  @SerializedName("select")
  SELECT("select");
}
