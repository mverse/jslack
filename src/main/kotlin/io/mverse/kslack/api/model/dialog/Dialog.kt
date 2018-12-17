package io.mverse.kslack.api.model.dialog

/**
 * Represents a Slack Modal Dialog
 *
 * @see [Slack Modal Dialog](https://api.slack.com/dialogs)
 */


data class Dialog(

  /**
   * User-facing title of this entire dialog. 24 characters to work with and it's required.
   */
  val title: String? = null,

  /**
   * An identifier strictly for you to recognize submissions of this particular instance of
   * a dialog. Use something meaningful to your app. 255 characters maximum.
   * Absolutely required.
   */
  val callbackId: String? = null,

  /**
   * Up to 5 form elements are allowed per dialog. Required.
   */
  val elements: List<DialogElement>? = null,

  /**
   * User-facing string for whichever button-like thing submits the form, depending on
   * form factor. Defaults to `Submit`, localized in whichever language the end user
   * prefers. 24 characters maximum, and may contain only a single word.
   */
  val submitLabel: String? = null)
