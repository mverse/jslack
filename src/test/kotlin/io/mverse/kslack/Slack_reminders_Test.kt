package io.mverse.kslack

import io.mverse.kslack.api.methods.request.reminders.RemindersAddRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersCompleteRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersDeleteRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersInfoRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_reminders_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(Exception::class)
  fun test() {
    val addResponse = slack.methods().remindersAdd(RemindersAddRequest(
        token = token,
        text = "Don't forget it!",
        time = "10"
    ))
    assertThat(addResponse.ok, `is`(true))

    val reminderId = addResponse.reminder!!.id

    val infoResponse = slack.methods().remindersInfo(RemindersInfoRequest(
        token = token,
        reminder = reminderId
    ))
    assertThat(infoResponse.ok, `is`(true))

    val completeResponse = slack.methods().remindersComplete(RemindersCompleteRequest(
        token = token,
        reminder = reminderId
    ))
    assertThat(completeResponse.ok, `is`(true))

    val deleteResponse = slack.methods().remindersDelete(RemindersDeleteRequest(
        token = token,
        reminder = reminderId
    ))
    assertThat(deleteResponse.ok, `is`(true))
  }
}