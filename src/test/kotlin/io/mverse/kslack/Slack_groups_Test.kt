package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.groups.GroupsArchiveRequest
import io.mverse.kslack.api.methods.request.groups.GroupsCloseRequest
import io.mverse.kslack.api.methods.request.groups.GroupsCreateChildRequest
import io.mverse.kslack.api.methods.request.groups.GroupsCreateRequest
import io.mverse.kslack.api.methods.request.groups.GroupsHistoryRequest
import io.mverse.kslack.api.methods.request.groups.GroupsInfoRequest
import io.mverse.kslack.api.methods.request.groups.GroupsListRequest
import io.mverse.kslack.api.methods.request.groups.GroupsMarkRequest
import io.mverse.kslack.api.methods.request.groups.GroupsRenameRequest
import io.mverse.kslack.api.methods.request.groups.GroupsSetPurposeRequest
import io.mverse.kslack.api.methods.request.groups.GroupsSetTopicRequest
import io.mverse.kslack.api.methods.request.groups.GroupsUnarchiveRequest
import io.mverse.kslack.api.model.Group
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_groups_Test {

  internal var slack = io.mverse.kslack.Slack()

  @Test

  fun groups() = runBlocking {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    val name = "secret-" + System.currentTimeMillis()
    val creationResponse = slack.groupsCreate(
        GroupsCreateRequest(token, name=(name)))
    var group = creationResponse.group
    run {
      assertThat(creationResponse.ok, `is`(true))
      assertThat<Group>(creationResponse.group, `is`(notNullValue()))
    }

    run {
      val response = slack.groupsList(
          GroupsListRequest(token))
      assertThat(response.ok, `is`(true))
    }
    run {
      val response = slack.groupsList(
          GroupsListRequest(token, isExcludeArchived= true))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.groupsHistory(
          GroupsHistoryRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.groupsInfo(
          GroupsInfoRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    val childCreationResponse = slack.groupsCreateChild(
        GroupsCreateChildRequest(token, channel=(group!!.id)))
    group = childCreationResponse.group
    run { assertThat(childCreationResponse.ok, `is`(true)) }

    run {
      val postResponse = slack.chatPostMessage(
          ChatPostMessageRequest(token, text=("hello"), channel=(childCreationResponse.group!!.id)))

      val ts = postResponse.ts
      val response = slack.groupsMark(
          GroupsMarkRequest(token, channel= group!!.id, ts= ts))
      assertThat(response.ok, `is`(true))
    }

    run {
      val (isOk) = slack.groupsRename(
          GroupsRenameRequest(token, channel=(group!!.id), name=("$name-")))
      assertThat(isOk, `is`(true))
    }

    run {
      val response = slack.groupsSetPurpose(
          GroupsSetPurposeRequest(token, channel=(group!!.id), purpose=("purpose")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.groupsSetTopic(
          GroupsSetTopicRequest(token, channel=(group!!.id), topic=("topic")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.groupsArchive(
          GroupsArchiveRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.groupsUnarchive(
          GroupsUnarchiveRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.groupsClose(
          GroupsCloseRequest(token, channel=(group!!.id)))
      assertThat(response.ok, `is`(true))
    }
  }
}