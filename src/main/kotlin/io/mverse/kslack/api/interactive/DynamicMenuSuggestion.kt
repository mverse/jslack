package io.mverse.kslack.api.interactive

import com.google.gson.annotations.SerializedName
import io.mverse.kslack.api.model.Option
import io.mverse.kslack.api.model.OptionGroup
import io.mverse.kslack.api.model.dialog.DialogOption
import io.mverse.kslack.api.model.dialog.DialogOptionGroup

/**
 * The response from a server handling dynamic options from a dialog select element.
 */
data class DynamicMenuSuggestion(
    val options: List<Option>? = null,
    val optionGroups: List<OptionGroup>? = null,
    val selectedOptions: List<DialogOption>? = null,
    val dataSource: Datasource? = null,
    val minQueryLength: Int? = null) {

  enum class Datasource {
    @SerializedName("static") STATIC,
    @SerializedName("external") EXTERNAL,
    @SerializedName("users") USERS,
    @SerializedName("channels") CHANNELS,
    @SerializedName("conversations") CONVERSATIONS;

    val value: String = name.toLowerCase()
    override fun toString(): String = value
  }
}
