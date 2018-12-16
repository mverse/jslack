package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.dnd.DndInfoRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndTeamInfoRequest
import com.github.seratch.jslack.api.methods.request.users.UsersListRequest
import com.github.seratch.jslack.api.methods.response.dnd.DndTeamInfoResponse
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_dnd_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun dnd() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    val members = slack.methods().usersList(UsersListRequest(token = token, isPresence = (true))).members
    run {
      val user = members!![0].id
      val response = slack.methods().dndInfo(DndInfoRequest(token = token, user = (user)))
      assertThat(response.ok, `is`(true))
      assertThat<Int>(response.nextDndStartTs, `is`(notNullValue()))
    }

    run {
      val users = members!!.map { it.id }.filterNotNull()
      val response = slack.methods().dndTeamInfo(DndTeamInfoRequest(token = token, users = (users)))
      assertThat(response.ok, `is`(true))
      assertThat<Map<String, DndTeamInfoResponse.DndTeamMemberInfo>>(response.users, `is`(notNullValue()))
    }
  }
}