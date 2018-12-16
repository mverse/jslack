package com.github.seratch.jslack.api.model.dialog

/**
 * Represents a [text](https://api.slack.com/dialogs#text_elements)
 * dialog element
 *
 *
 *
 *
 * `Text` elements are single-line plain text fields.
 */
data class DialogTextElement(

  /**
   * Label displayed to user. Required. No more than 24 characters.
   */
  override val label: String,

  /**
   * Name of form element. Required. No more than 300 characters.
   */
  override val name: String,


  /**
   * A default value for this field. Up to 500 characters.
   */
  override val value: String,

  /**
   * A string displayed as needed to help guide users in completing the element.
   * 150 character maximum.
   */
  override val placeholder: String,

  /**
   * Provide `true` when the form element is not required. By default,
   * form elements are required.
   */
  override val isOptional: Boolean = false,

  /**
   * Maximum input length allowed for element. Up to 150 characters. Defaults to 150.
   */
  val maxLength: Int = 0,

  /**
   * Minimum input length allowed for element.
   * Type `text`: Up to 150 characters. Defaults to 0.
   */
  val minLength: Int = 0,

  /**
   * Helpful text provided to assist users in answering a question. Up to 150 characters.
   */
  val hint: String? = null,

  /**
   * Subtype for this text type element (e.g. Number)
   */
  val subtype: DialogSubType? = null) : DialogElement {

  /**
   * Type of element.  For a text element, the type is always
   * `text` . It's required.
   *
   * @see [Dialog form elements](https://api.slack.com/dialogs.elements)
   */
  override val type = "text"

}
