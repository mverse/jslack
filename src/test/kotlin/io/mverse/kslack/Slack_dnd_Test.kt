package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.dnd.DndInfoRequest
import io.mverse.kslack.api.methods.request.dnd.DndTeamInfoRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import io.mverse.kslack.api.methods.response.dnd.DndTeamInfoResponse
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_dnd_Test {

  internal var slack = io.mverse.kslack.Slack()

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun dnd() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    val members = slack.usersList(UsersListRequest(token = token, isPresence = (true))).members
    run {
      val user = members!![0].id
      val response = slack.dndInfo(DndInfoRequest(token = token, user = (user)))
      assertThat(response.ok, `is`(true))
      assertThat<Int>(response.nextDndStartTs, `is`(notNullValue()))
    }

    run {
      val users = members!!.map { it.id }.filterNotNull()
      val response = slack.dndTeamInfo(DndTeamInfoRequest(token = token, users = (users)))
      assertThat(response.ok, `is`(true))
      assertThat<Map<String, DndTeamInfoResponse.DndTeamMemberInfo>>(response.users, `is`(notNullValue()))
    }
  }
}