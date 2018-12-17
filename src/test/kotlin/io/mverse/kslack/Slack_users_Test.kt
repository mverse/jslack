package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.users.UsersConversationsRequest
import io.mverse.kslack.api.methods.request.users.UsersDeletePhotoRequest
import io.mverse.kslack.api.methods.request.users.UsersGetPresenceRequest
import io.mverse.kslack.api.methods.request.users.UsersIdentityRequest
import io.mverse.kslack.api.methods.request.users.UsersInfoRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import io.mverse.kslack.api.methods.request.users.UsersLookupByEmailRequest
import io.mverse.kslack.api.methods.request.users.UsersSetActiveRequest
import io.mverse.kslack.api.methods.request.users.UsersSetPhotoRequest
import io.mverse.kslack.api.methods.request.users.UsersSetPresenceRequest
import io.mverse.kslack.api.model.User
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.io.IOException

class Slack_users_Test {

  internal var slack = io.mverse.kslack.Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun users() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    run {
      val response = slack.methods().usersSetPresence(
          UsersSetPresenceRequest(token, presence = ("away")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().usersSetActive(
          UsersSetActiveRequest(token))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().usersIdentity(UsersIdentityRequest(token))
      // TODO: test preparation?
      // {"ok":false,"error":"missing_scope","needed":"identity.basic","provided":"identify,read,post,client,apps,admin"}
      assertThat(response.ok, `is`(false))
    }

    val usersListResponse = slack.methods().usersList(UsersListRequest(
        token = token,
        limit = 2,
        isPresence = true))

    val users = usersListResponse.members
    val userId = users!![0].id

    run {
      assertThat(usersListResponse.ok, `is`(true))
      assertThat(usersListResponse.responseMetadata, `is`(notNullValue()))

      assertThat(users, `is`(notNullValue()))
      val (id, _, name, _, _, realName, _, _, _, profile) = users[0]
      assertThat<String>(id, `is`(notNullValue()))
      assertThat<String>(name, `is`(notNullValue()))
      assertThat<String>(realName, `is`(notNullValue()))

      // As of 2018/07, these APIs are no longer supported
      // assertThat(user.getProfile().getFirstName(), is(nullValue()));
      // assertThat(user.getProfile().getLastName(), is(nullValue()));
      assertThat<String>(profile!!.displayName, `is`(notNullValue()))
      assertThat<String>(profile.displayNameNormalized, `is`(notNullValue()))
      assertThat<String>(profile.realName, `is`(notNullValue()))
      assertThat<String>(profile.realNameNormalized, `is`(notNullValue()))

      assertThat<String>(profile.image24, `is`(notNullValue()))
      assertThat<String>(profile.image32, `is`(notNullValue()))
      assertThat<String>(profile.image48, `is`(notNullValue()))
      assertThat<String>(profile.image72, `is`(notNullValue()))
      assertThat<String>(profile.image192, `is`(notNullValue()))
      assertThat<String>(profile.image512, `is`(notNullValue()))
    }

    run {
      val response = slack.methods().usersInfo(UsersInfoRequest(token, user = (userId)))
      assertThat(response.ok, `is`(true))
      assertThat<User>(response.user, `is`(notNullValue()))
    }

    run {
      val response = slack.methods().usersGetPresence(
          UsersGetPresenceRequest(token, user = userId))
      assertThat(response.ok, `is`(true))
      assertThat<String>(response.presence, `is`(notNullValue()))
    }

    run {
      val response = slack.methods().usersConversations(UsersConversationsRequest(
          token = token,
          user = userId))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().usersDeletePhoto(
          UsersDeletePhotoRequest(token))
      assertThat(response.ok, `is`(true))
    }

    val image = File("src/test/resources/user_photo.jpg")
    run {
      val response = slack.methods().usersSetPhoto(UsersSetPhotoRequest(
          token = token,
          image = image))
      assertThat(response.ok, `is`(true))
    }
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun lookupByEMailSupported() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val usersListResponse = slack.methods().usersList(UsersListRequest(
        token = token,
        isPresence = true
    ))

    val users = usersListResponse.members
    var randomUserWhoHasEmail: User? = null
    for (user in users!!) {
      if (user.profile != null && user.profile!!.email != null) {
        randomUserWhoHasEmail = user
        break
      }
    }
    if (randomUserWhoHasEmail == null) {
      throw IllegalStateException("Create a non-bot user for this test case in advance.")
    }

    val response = slack.methods().usersLookupByEmail(UsersLookupByEmailRequest(
        token = token,
        email = randomUserWhoHasEmail.profile!!.email
    ))

    assertTrue(response.ok)
    assertEquals(randomUserWhoHasEmail.id, response.user!!.id)
  }
}