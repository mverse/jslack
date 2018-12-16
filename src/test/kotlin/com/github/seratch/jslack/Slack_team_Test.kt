package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.request.team.TeamAccessLogsRequest
import com.github.seratch.jslack.api.methods.request.team.TeamBillableInfoRequest
import com.github.seratch.jslack.api.methods.request.team.TeamInfoRequest
import com.github.seratch.jslack.api.methods.request.team.TeamIntegrationLogsRequest
import com.github.seratch.jslack.api.methods.request.team.profile.TeamProfileGetRequest
import com.github.seratch.jslack.api.methods.request.users.UsersListRequest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_team_Test {

  internal var slack = Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  fun teamAccessLogs() {
    val response = slack.methods().teamAccessLogs(TeamAccessLogsRequest(
        token = token))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("paid_only"))
  }

  @Test
  fun teamBillableInfo() {
    val userData = slack.methods().usersList(UsersListRequest(token)).members!!.filter { !it.isBot && it.name != "slackbot" }.first()
    val user = userData.id
    val response = slack.methods().teamBillableInfo(TeamBillableInfoRequest(
        token = token,
        user = user))
    assertThat(response.toString(), response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun teamInfo() {
    val response = slack.methods().teamInfo(TeamInfoRequest(
        token = token))
    assertThat(response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun teamIntegrationLogs() {
    val user = slack.methods().usersList(UsersListRequest(token)).members!![0].id
    val response = slack.methods().teamIntegrationLogs(TeamIntegrationLogsRequest(
        token = token,
        user = user))
    assertThat(response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun teamProfileGet() {
    val response = slack.methods().teamProfileGet(TeamProfileGetRequest(token))
    assertThat(response.ok, `is`(true))
  }
}