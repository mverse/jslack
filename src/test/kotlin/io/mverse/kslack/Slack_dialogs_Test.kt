package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.dialog.DialogOpenRequest
import io.mverse.kslack.api.model.dialog.Dialog
import io.mverse.kslack.api.model.dialog.DialogSubType
import io.mverse.kslack.api.model.dialog.DialogTextElement
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_dialogs_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun open() {

    val quanityTextElement = DialogTextElement(
        subtype = DialogSubType.NUMBER,
        label = "Quantity",
        name = "quantity",
        hint = "The number you need",
        maxLength = 3,
        minLength = 1,
        placeholder = "Required quantity",
        value = "1")

    val dialog = Dialog(
        title = "Request pens",
        callbackId = "pens-1122",
        elements = listOf(quanityTextElement),
        submitLabel = "")

    /*
         * A dialog in Slack can only be opened in response to a user action such as a slash command or
         * button click (which now include trigger_ids in callbacks). A dialog.open request has to include
         * that same trigger_id in order to succeed. The dialog.open request must also be made within 3
         * seconds of the user action.  Therefore, only an 'invalid trigger' ID response can be tested.
         */
    val dialogOpenResponse = slack.methods().dialogOpen(DialogOpenRequest(
        token = token,
        triggerId = "FAKE_TRIGGER_ID",
        dialog = dialog))
    assertThat(dialogOpenResponse.ok, `is`(false))
    assertThat<String>(dialogOpenResponse.error, `is`("invalid_trigger"))
  }
}
