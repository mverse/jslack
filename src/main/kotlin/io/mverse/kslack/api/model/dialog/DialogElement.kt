package io.mverse.kslack.api.model.dialog

/**
 * A dialog Form DialogElement such as `text`, `textarea`, or `select`
 * or `select`.
 *
 * @see [Slack Modal Dialog](https://api.slack.com/dialogs)
 */
interface DialogElement {

  val label: String

  val name: String

  val type: String

  val value: String

  val placeholder: String

  val isOptional: Boolean
}
