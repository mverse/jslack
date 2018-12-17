package io.mverse.kslack.api.model.dialog

import com.google.gson.annotations.SerializedName

/**
 * Represents a [select](https://api.slack.com/dialogs#select_elements)
 * dialog element
 *
 * Use the `select` element for multiple choice selections allowing users to pick a
 * single item from a list. True to web roots, this selection is displayed as a dropdown
 * menu.
 */
data class DialogSelectElement(

    /**
     * Label displayed to user. Required. No more than 24 characters.
     */
    override val label: String,

    /**
     * Name of form element. Required. No more than 300 characters.
     */
    override val name: String,

    /**
     * A default value for this field.  Must match a value presented in [DialogOption]s.
     */
    override val value: String,

    /**
     * A string displayed as needed to help guide users in completing the element.
     * 150 character maximum.
     */
    override val placeholder: String,

    /**
     * Provide true when the form element is not required. By default, form elements are
     * required.
     */
    override val optional: Boolean = false,

    /**
     * How to populate the options. For dynamic select, use []Datasource.EXTERNAL]
     */
    val dataSource: Datasource = Datasource.STATIC,

    /**
     * Minimum characters for a user to type before initiating a search
     */
    val minQueryLength: Int? = null,

    /**
     * Provide up to 100 option element attributes. Required (or optionGroups) for this type.
     */
    val options: List<DialogOption>? = null,

    /**
     * Provide up to 100 option element attributes. Required for this type.
     */
    val optionGroups: List<DialogOptionGroup>? = null) : DialogElement {

  /**
   * Type of element.  For a dropdown (select), the type is always
   * `select` . It's required.
   *
   * @see [Dialog form elements](https://api.slack.com/dialogs.elements)
   */
  override val type: String = "select"

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
