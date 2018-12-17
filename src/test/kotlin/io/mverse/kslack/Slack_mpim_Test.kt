package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.mpim.MpimCloseRequest
import io.mverse.kslack.api.methods.request.mpim.MpimHistoryRequest
import io.mverse.kslack.api.methods.request.mpim.MpimListRequest
import io.mverse.kslack.api.methods.request.mpim.MpimMarkRequest
import io.mverse.kslack.api.methods.request.mpim.MpimOpenRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test
import java.io.IOException

class Slack_mpim_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  // TODO: fix this tests
  @Ignore
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun operations() {
    val listResponse = slack.mpimList(MpimListRequest(token))
    assertThat(listResponse.ok, `is`(true))

    val usersListResponse = slack.usersList(UsersListRequest(token, isPresence = (true)))
    val users = usersListResponse.members
    val userIds = users!!.filter { !it.isDeleted && !it.isRestricted }
        .map { it.id }.filterNotNull()

    val openResponse = slack.mpimOpen(MpimOpenRequest(token, users=(userIds)))
    assertThat(openResponse.ok, `is`(true))

    val channelId = openResponse.group!!.id

    val markResponse = slack.mpimMark(MpimMarkRequest(token, channel=(channelId)))
    assertThat(markResponse.ok, `is`(true))

    val historyResponse = slack.mpimHistory(MpimHistoryRequest(token, channel=(channelId)))
    assertThat(historyResponse.ok, `is`(true))

    val closeResponse = slack.mpimClose(MpimCloseRequest(token, channel=(channelId)))
    assertThat(closeResponse.ok, `is`(true))
  }
}