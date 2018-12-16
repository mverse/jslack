package com.github.seratch.jslack

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsArchiveRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsCloseRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsCreateChildRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsCreateRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsHistoryRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsInfoRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsListRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsMarkRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsRenameRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsSetPurposeRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsSetTopicRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsUnarchiveRequest
import com.github.seratch.jslack.api.model.Group
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_groups_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun groups() {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    val name = "secret-" + System.currentTimeMillis()
    val creationResponse = slack.methods().groupsCreate(
        GroupsCreateRequest(token, name=(name)))
    var group = creationResponse.group
    run {
      assertThat(creationResponse.ok, `is`(true))
      assertThat<Group>(creationResponse.group, `is`(notNullValue()))
    }

    run {
      val response = slack.methods().groupsList(
          GroupsListRequest(token))
      assertThat(response.ok, `is`(true))
    }
    run {
      val response = slack.methods().groupsList(
          GroupsListRequest(token, isExcludeArchived= true))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().groupsHistory(
          GroupsHistoryRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().groupsInfo(
          GroupsInfoRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    val childCreationResponse = slack.methods().groupsCreateChild(
        GroupsCreateChildRequest(token, channel=(group!!.id)))
    group = childCreationResponse.group
    run { assertThat(childCreationResponse.ok, `is`(true)) }

    run {
      val postResponse = slack.methods().chatPostMessage(
          ChatPostMessageRequest(token, text=("hello"), channel=(childCreationResponse.group!!.id)))

      val ts = postResponse.ts
      val response = slack.methods().groupsMark(
          GroupsMarkRequest(token, channel= group!!.id, ts= ts))
      assertThat(response.ok, `is`(true))
    }

    run {
      val (isOk) = slack.methods().groupsRename(
          GroupsRenameRequest(token, channel=(group!!.id), name=("$name-")))
      assertThat(isOk, `is`(true))
    }

    run {
      val response = slack.methods().groupsSetPurpose(
          GroupsSetPurposeRequest(token, channel=(group!!.id), purpose=("purpose")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().groupsSetTopic(
          GroupsSetTopicRequest(token, channel=(group!!.id), topic=("topic")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().groupsArchive(
          GroupsArchiveRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().groupsUnarchive(
          GroupsUnarchiveRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.methods().groupsClose(
          GroupsCloseRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }
  }
}