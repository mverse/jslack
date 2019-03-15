package io.mverse.kslack

import io.mverse.kslack.api.methods.request.search.SearchAllRequest
import io.mverse.kslack.api.methods.request.search.SearchFilesRequest
import io.mverse.kslack.api.methods.request.search.SearchMessagesRequest
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_search_Test {

  internal var slack = io.mverse.kslack.Slack()
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  fun all() = runBlocking {
    val response = slack.searchAll(
        SearchAllRequest(token, query = ("test")))

    assertThat(response.ok, `is`(true))
  }

  @Test
  fun messages() = runBlocking {
    val response = slack.searchMessages(
        SearchMessagesRequest(token, query = ("test")))
    assertThat(response.ok, `is`(true))

    val (_, _, user, username) = response.messages!!.matches!![0]
    assertThat<String>(user, `is`(notNullValue()))
    assertThat<String>(username, `is`(notNullValue()))
  }

//  @Test()
  fun files() = runBlocking {
    val response = slack.searchFiles(
        SearchFilesRequest(token, query = ("test")))
    assertThat(response.ok, `is`(true))

    val matchedItem = response.files!!.matches!![0]
    assertThat<String>(matchedItem.user, `is`(notNullValue()))
    assertThat<String>(matchedItem.username, `is`(notNullValue()))
  }
}