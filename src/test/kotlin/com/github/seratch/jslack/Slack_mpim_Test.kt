package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.mpim.MpimCloseRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimHistoryRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimListRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimMarkRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimOpenRequest
import com.github.seratch.jslack.api.methods.request.users.UsersListRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test
import java.io.IOException

class Slack_mpim_Test {

  internal var slack = Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  // TODO: fix this tests
  @Ignore
  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun operations() {
    val listResponse = slack.methods().mpimList(MpimListRequest(token))
    assertThat(listResponse.ok, `is`(true))

    val usersListResponse = slack.methods().usersList(UsersListRequest(token, isPresence = (true)))
    val users = usersListResponse.members
    val userIds = users!!.filter { !it.isDeleted && !it.isRestricted }
        .map { it.id }.filterNotNull()

    val openResponse = slack.methods().mpimOpen(MpimOpenRequest(token, users=(userIds)))
    assertThat(openResponse.ok, `is`(true))

    val channelId = openResponse.group!!.id

    val markResponse = slack.methods().mpimMark(MpimMarkRequest(token, channel=(channelId)))
    assertThat(markResponse.ok, `is`(true))

    val historyResponse = slack.methods().mpimHistory(MpimHistoryRequest(token, channel=(channelId)))
    assertThat(historyResponse.ok, `is`(true))

    val closeResponse = slack.methods().mpimClose(MpimCloseRequest(token, channel=(channelId)))
    assertThat(closeResponse.ok, `is`(true))
  }
}