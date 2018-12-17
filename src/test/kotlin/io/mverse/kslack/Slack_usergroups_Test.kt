package io.mverse.kslack

import io.mverse.kslack.api.methods.request.usergroups.UsergroupsCreateRequest
import io.mverse.kslack.api.methods.request.usergroups.UsergroupsListRequest
import io.mverse.kslack.api.methods.request.usergroups.users.UsergroupUsersListRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.anyOf
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_usergroups_Test {

  internal var slack = io.mverse.kslack.Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(Exception::class)
  fun create() {
    val response = slack.methods().usergroupsCreate(UsergroupsCreateRequest(
        token = token,
        name = "usergroup-" + System.currentTimeMillis()
    ))
    assertThat(response.ok, `is`(false))
    assertThat<String>(response.error, `is`(anyOf(
        // For a good old token, "paid_teams_only" can be returned as the error
        equalTo("paid_teams_only"),
        // As of 2018, this code is generally returned for newly created token
        equalTo("missing_scope")
    )))
  }

  @Test
  @Throws(Exception::class)
  fun list() {
    val response = slack.methods().usergroupsList(UsergroupsListRequest(token))
    assertThat(response.ok, `is`(true))
  }

  @Test
  @Throws(Exception::class)
  fun users() {
    val usergroups = slack.methods().usergroupsList(UsergroupsListRequest(token))
    if (usergroups.ok && usergroups.usergroups!!.size > 0) {
      val response = slack.methods().usergroupUsersList(
          UsergroupUsersListRequest(
              token = token,
              isIncludeDisabled = false,
              usergroup = usergroups.usergroups!![0].id
          ))
      assertThat(response.ok, `is`(false))
      //            assertThat(response.getError(), is("missing_required_argument"));
      // As of 2018/05, the error message has been changed
      assertThat<String>(response.error, `is`("no_such_subteam"))
    }
  }

  @Test
  @Throws(Exception::class)
  fun users_failure() {
    val response = slack.methods().usergroupUsersList(
        UsergroupUsersListRequest(
            token = token,
            isIncludeDisabled = false,
            usergroup = "dummy"
        ))
    assertThat(response.ok, `is`(false))
    //            assertThat(response.getError(), is("missing_required_argument"));
    // As of 2018/05, the error message has been changed
    assertThat<String>(response.error, `is`("no_such_subteam"))
  }
}