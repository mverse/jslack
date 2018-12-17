package io.mverse.kslack.api.methods.request.dialog

import io.mverse.kslack.api.methods.SlackApiRequest
import io.mverse.kslack.api.model.dialog.Dialog

data class DialogOpenRequest(

  /**
   * Authentication token. Requires scope: `none`
   */
  val token: String,

  /**
   * The dialog definition. This must be a JSON-encoded string.
   */
  val dialog: Dialog? = null,

  /**
   * Exchange a trigger to post to the user.
   *
   *
   * Apps can invoke dialogs when users interact with slash commands, message buttons,
   * or message menus. Each interaction will include a trigger_id.
   *
   *
   *
   *
   * As apps can only open a dialog in response to such a user action, the
   * `trigger_id` is a required parameter.
   *
   * @see [Implementing dialogs](https://api.slack.com/dialogs.implementation)
   */
  val triggerId: String? = null): SlackApiRequest
