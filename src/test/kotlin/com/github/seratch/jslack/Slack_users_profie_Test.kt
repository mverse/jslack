package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileGetRequest
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileSetRequest
import com.github.seratch.jslack.api.model.User
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_users_profie_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun usersProfile() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    run {
      val response = slack.methods().usersProfileGet(UsersProfileGetRequest(token))
      assertThat(response.ok, `is`(true))
      assertThat<User.Profile>(response.profile, `is`(notNullValue()))
    }

    run {
      val response = slack.methods().usersProfileSet(
          UsersProfileSetRequest(token, name=("skype"), value=("skype-" + System.currentTimeMillis())))
      assertThat(response.ok, `is`(true))
      assertThat<User.Profile>(response.profile, `is`(notNullValue()))
    }

    run {
      val profile = User.Profile(skype = "skype-" + System.currentTimeMillis())
      val response = slack.methods().usersProfileSet(
          UsersProfileSetRequest(token, profile=(profile)))
      assertThat(response.ok, `is`(true))
      assertThat<User.Profile>(response.profile, `is`(notNullValue()))
    }
  }
}