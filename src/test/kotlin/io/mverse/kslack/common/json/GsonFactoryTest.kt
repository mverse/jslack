package io.mverse.kslack.common.json

import assertk.assert
import assertk.assertions.isInstanceOf
import io.mverse.kslack.api.interactive.DialogSubmissionPayload
import io.mverse.kslack.api.interactive.DialogSuggestionPayload
import io.mverse.kslack.api.interactive.InteractivePayload
import io.mverse.kslack.api.interactive.OptionsPayload
import org.junit.Test

class GsonFactoryTest {

  @Test
  fun gsonInteractiveMessage() {

  }

  @Test
  fun gsonDialogSuggestion() {
    val payload = "{\"type\":\"dialog_suggestion\",\"token\":\"zDe5HTzx5PrEzpDyb5e5tC42\",\"action_ts\":\"1545187230.176392\",\"team\":{\"id\":\"TEM9JEKM0\",\"domain\":\"slick-testing\"},\"user\":{\"id\":\"UELH8NY1W\",\"name\":\"smartytime\"},\"channel\":{\"id\":\"CEM4KJLKE\",\"name\":\"general\"},\"name\":\"\\/tag\",\"value\":\"\",\"callback_id\":\"f1527063-dfe1-4559-a39f-7e75f20180ab\",\"state\":\"\"}"
    val interactive: OptionsPayload = GsonFactory.createSnakeCase()
        .fromJson(payload)
    assert(interactive).isInstanceOf(DialogSuggestionPayload::class.java)
  }

  @Test
  fun gsonDialogSubmission() {
    val payload = "{\"type\":\"dialog_submission\",\"token\":\"zDe5HTzx5PrEzpDyb5e5tC42\",\"action_ts\":\"1545188347.983180\",\"team\":{\"id\":\"TEM9JEKM0\",\"domain\":\"slick-testing\"},\"user\":{\"id\":\"UELH8NY1W\",\"name\":\"smartytime\"},\"channel\":{\"id\":\"CEM4KJLKE\",\"name\":\"general\"},\"submission\":{\"\\/contact\":\"7\",\"\\/tag\":\"103\"},\"callback_id\":\"0a368230-a4f2-4302-9398-90b17cf5dfd7\",\"response_url\":\"https:\\/\\/hooks.slack.com\\/app\\/TEM9JEKM0\\/508546444231\\/NvvoCjxGfYwCFhNKVPPApcke\",\"state\":\"\"}"
    val interactive: InteractivePayload = GsonFactory.createSnakeCase()
        .fromJson(payload)
    assert(interactive).isInstanceOf(DialogSubmissionPayload::class.java)
  }
}