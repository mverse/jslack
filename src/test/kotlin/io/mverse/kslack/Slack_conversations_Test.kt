package io.mverse.kslack

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsArchiveRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsCloseRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsCreateRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsHistoryRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsInfoRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsInviteRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsJoinRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsKickRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsLeaveRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsListRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsMembersRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsOpenRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsRenameRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsRepliesRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsSetPurposeRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsSetTopicRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import io.mverse.kslack.api.model.Conversation
import io.mverse.kslack.api.model.ConversationType
import io.mverse.kslack.api.model.ResponseMetadata
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_conversations_Test {

  internal var slack = io.mverse.kslack.Slack.instance
  internal var token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun channelConversation() {

    run {
      val listResponse = slack.methods().conversationsList(
          ConversationsListRequest(
              token = token,
              isExcludeArchived = true,
              limit = 10,
              types = listOf(ConversationType.PUBLIC_CHANNEL)))

      assertThat(listResponse.ok, `is`(true))
      assertThat<List<Conversation>>(listResponse.channels, `is`(notNullValue()))
      assertThat<ResponseMetadata>(listResponse.responseMetadata, `is`(notNullValue()))
    }

    val createPublicResponse = slack.methods().conversationsCreate(
        ConversationsCreateRequest(
            token = token,
            name = "test" + System.currentTimeMillis(),
            isPrivate = false
        ))
    assertThat(createPublicResponse.ok, `is`(true))
    assertThat<Conversation>(createPublicResponse.channel, `is`(notNullValue()))
    assertThat(createPublicResponse.channel!!.isPrivate, `is`(false))

    val channel = createPublicResponse.channel

    val createPrivateResponse = slack.methods().conversationsCreate(
        ConversationsCreateRequest(
            token = token,
            name = "test" + System.currentTimeMillis(),
            isPrivate = true
        ))
    assertThat(createPrivateResponse.ok, `is`(true))
    assertThat<Conversation>(createPrivateResponse.channel, `is`(notNullValue()))
    assertThat(createPrivateResponse.channel!!.isPrivate, `is`(true))

    run {
      val postMessageResponse = slack.methods().chatPostMessage(
          ChatPostMessageRequest(
              token = token,
              channel = createPublicResponse.channel!!.id,
              text = "This is a test message posted by unit tests for jslack library",
              isReplyBroadcast = false
          ))
      assertThat(postMessageResponse.ok, `is`(true))

      val postThread1Response = slack.methods().chatPostMessage(
          ChatPostMessageRequest(
              token = token,
              channel = createPublicResponse.channel!!.id,
              threadTs = postMessageResponse.ts,
              text = "[thread 1] This is a test message posted by unit tests for jslack library",
              isReplyBroadcast = false
          ))
      assertThat(postThread1Response.ok, `is`(true))

      val postThread2Response = slack.methods().chatPostMessage(
          ChatPostMessageRequest(
              token = token,
              channel = createPublicResponse.channel!!.id,
              threadTs = postMessageResponse.ts,
              text = "[thread 2] This is a test message posted by unit tests for jslack library",
              isReplyBroadcast = false
          ))
      assertThat(postThread2Response.ok, `is`(true))

      val repliesResponse = slack.methods().conversationsReplies(
          ConversationsRepliesRequest(
              token = token,
              channel = createPublicResponse.channel!!.id,
              ts = postMessageResponse.ts,
              limit = 1))

      assertThat(repliesResponse.ok, `is`(true))
      assertThat<ResponseMetadata>(repliesResponse.responseMetadata, `is`(notNullValue()))
    }

    run {
      val infoResponse = slack.methods().conversationsInfo(
          ConversationsInfoRequest(
              token = token,
              channel = channel!!.id,
              isIncludeLocale = true
          ))
      assertThat(infoResponse.ok, `is`(true))
      val fetchedConversation = infoResponse.channel
      assertThat(fetchedConversation!!.isMember, `is`(true))
      assertThat(fetchedConversation.isGeneral, `is`(false))
      assertThat(fetchedConversation.isArchived, `is`(false))
      assertThat(fetchedConversation.isIm, `is`(false))
      assertThat(fetchedConversation.isMpim, `is`(false))
      assertThat(fetchedConversation.isGroup, `is`(false))

    }

    run {
      val setPurposeResponse = slack.methods().conversationsSetPurpose(
          ConversationsSetPurposeRequest(
              token = token,
              channel = channel!!.id,
              purpose = "purpose"
          ))
      assertThat(setPurposeResponse.ok, `is`(true))
      assertThat<String>(setPurposeResponse.channel!!.purpose!!.value, `is`("purpose"))
    }

    run {
      val setTopicResponse = slack.methods().conversationsSetTopic(
          ConversationsSetTopicRequest(
              token = token,
              channel = channel!!.id,
              topic = "topic"
          ))
      assertThat(setTopicResponse.ok, `is`(true))
      assertThat<String>(setTopicResponse.channel!!.topic!!.value, `is`("topic"))
    }

    run {
      val historyResponse = slack.methods().conversationsHistory(
          ConversationsHistoryRequest(
              token = token,
              channel = channel!!.id,
              limit = 2))
      assertThat(historyResponse.ok, `is`(true))
      // The outcome depends on data
      // assertThat(historyResponse.isHasMore(), is(false));
      assertThat<ResponseMetadata>(historyResponse.responseMetadata, `is`(notNullValue()))
    }

    run {
      val membersResponse = slack.methods().conversationsMembers(
          ConversationsMembersRequest(
              token = token,
              channel = channel!!.id,
              limit = 2))
      assertThat(membersResponse.ok, `is`(true))
      assertThat<List<String>>(membersResponse.members, `is`(notNullValue()))
      assertThat(membersResponse.members!!.isEmpty(), `is`(false))
      assertThat<ResponseMetadata>(membersResponse.responseMetadata, `is`(notNullValue()))

      val usersListResponse = slack.methods().usersList(
          UsersListRequest(token = (token)))
      val invitee = usersListResponse.members!!.first {
        !membersResponse.members!!.contains(it.id) && it.name != "slackbot" && it.isBot==false
      }

      val inviteResponse = slack.methods().conversationsInvite(
          ConversationsInviteRequest(
              token = token,
              channel = channel.id,
              users = listOf(invitee.id!!)
          ))
      assertThat(inviteResponse.toString(), inviteResponse.ok, `is`(true))

      val kickResponse = slack.methods().conversationsKick(
          ConversationsKickRequest(
              token = token,
              channel = channel.id,
              user = invitee.id!!
          ))
      assertThat(kickResponse.ok, `is`(true))
    }

    run {
      val leaveResponse = slack.methods().conversationsLeave(
          ConversationsLeaveRequest(
              token = token,
              channel = channel!!.id
          ))
      assertThat(leaveResponse.ok, `is`(true))
    }

    run {
      val joinResponse = slack.methods().conversationsJoin(
          ConversationsJoinRequest(
              token = token,
              channel = channel!!.id
          ))
      assertThat(joinResponse.ok, `is`(true))
    }

    run {
      val renameResponse = slack.methods().conversationsRename(
          ConversationsRenameRequest(
              token = token,
              channel = channel!!.id,
              name = channel.name!! + "-1"
          ))
      assertThat(renameResponse.ok, `is`(true))
    }

    run {
      val archieveResponse = slack.methods().conversationsArchive(
          ConversationsArchiveRequest(
              token = token,
              channel = channel!!.id
          ))
      assertThat(archieveResponse.ok, `is`(true))
    }

    run {
      val infoResponse = slack.methods().conversationsInfo(
          ConversationsInfoRequest(
              token = token,
              channel = channel!!.id
          ))
      assertThat(infoResponse.ok, `is`(true))
      val fetchedChannel = infoResponse.channel
      assertThat(fetchedChannel!!.isMember, `is`(false))
      assertThat(fetchedChannel.isGeneral, `is`(false))
      assertThat(fetchedChannel.isArchived, `is`(true))
    }
  }

  @Test
  @Throws(IOException::class, SlackApiException::class)
  fun imConversation() {

    val usersListResponse = slack.methods().usersList(
        UsersListRequest(token))
    val users = usersListResponse.members
    val userId = users!![0].id

    val openResponse = slack.methods().conversationsOpen(
        ConversationsOpenRequest(
            token = token,
            users = listOf(userId!!),
            isReturnIm = true
        ))
    assertThat(openResponse.ok, `is`(true))

    val membersResponse = slack.methods().conversationsMembers(
        ConversationsMembersRequest(
            token = token,
            channel = openResponse.channel!!.id
        ))
    assertThat(membersResponse.ok, `is`(true))
    assertThat<List<String>>(membersResponse.members, `is`(notNullValue()))
    assertThat(membersResponse.members!!.isEmpty(), `is`(false))

    val closeResponse = slack.methods().conversationsClose(
        ConversationsCloseRequest(token = token, channel = (openResponse.channel!!.id)))
    assertThat(closeResponse.ok, `is`(true))
  }
}
