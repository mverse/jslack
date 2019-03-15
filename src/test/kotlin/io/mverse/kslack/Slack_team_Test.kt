package io.mverse.kslack

import io.mverse.kslack.api.methods.request.team.TeamAccessLogsRequest
import io.mverse.kslack.api.methods.request.team.TeamBillableInfoRequest
import io.mverse.kslack.api.methods.request.team.TeamInfoRequest
import io.mverse.kslack.api.methods.request.team.TeamIntegrationLogsRequest
import io.mverse.kslack.api.methods.request.team.profile.TeamProfileGetRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_team_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  fun teamAccessLogs() = runBlocking {
    val response = slack.teamAccessLogs(TeamAccessLogsRequest(
        token = token))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`("paid_only"))
  }

  @Test
  fun teamBillableInfo() = runBlocking {
    val userData = slack.usersList(UsersListRequest(token)).members!!.filter { !it.isBot && it.name != "slackbot" }.first()
    val user = userData.id
    val response = slack.teamBillableInfo(TeamBillableInfoRequest(
        token = token,
        user = user))
    assertThat(response.toString(), response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun teamInfo() = runBlocking {
    val response = slack.teamInfo(TeamInfoRequest(
        token = token))
    assertThat(response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun teamIntegrationLogs() = runBlocking {
    val user = slack.usersList(UsersListRequest(token)).members!![0].id
    val response = slack.teamIntegrationLogs(TeamIntegrationLogsRequest(
        token = token,
        user = user))
    assertThat(response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun teamProfileGet() = runBlocking {
    val response = slack.teamProfileGet(TeamProfileGetRequest(token))
    assertThat(response.ok, `is`(true))
  }
}