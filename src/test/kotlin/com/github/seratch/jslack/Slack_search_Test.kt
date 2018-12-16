package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.request.search.SearchAllRequest
import com.github.seratch.jslack.api.methods.request.search.SearchFilesRequest
import com.github.seratch.jslack.api.methods.request.search.SearchMessagesRequest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test

class Slack_search_Test {

  internal var slack = Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  fun all() {
    val response = slack.methods().searchAll(
        SearchAllRequest(token, query = ("test")))

    assertThat(response.ok, `is`(true))
  }

  @Test
  fun messages() {
    val response = slack.methods().searchMessages(
        SearchMessagesRequest(token, query = ("test")))
    assertThat(response.ok, `is`(true))

    val (_, _, user, username) = response.messages!!.matches!![0]
    assertThat<String>(user, `is`(notNullValue()))
    assertThat<String>(username, `is`(notNullValue()))
  }

//  @Test()
  fun files() {
    val response = slack.methods().searchFiles(
        SearchFilesRequest(token, query = ("test")))
    assertThat(response.ok, `is`(true))

    val matchedItem = response.files!!.matches!![0]
    assertThat<String>(matchedItem.user, `is`(notNullValue()))
    assertThat<String>(matchedItem.username, `is`(notNullValue()))
  }
}