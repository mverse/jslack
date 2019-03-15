package io.mverse.kslack

import assertk.assertions.isNull
import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.methods.request.channels.ChannelsArchiveRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsCreateRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsHistoryRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsInfoRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsInviteRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsJoinRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsKickRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsLeaveRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsRenameRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsRepliesRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsSetPurposeRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsSetTopicRequest
import io.mverse.kslack.api.methods.request.chat.ChatDeleteRequest
import io.mverse.kslack.api.methods.request.chat.ChatGetPermalinkRequest
import io.mverse.kslack.api.methods.request.chat.ChatMeMessageRequest
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.chat.ChatUnfurlRequest
import io.mverse.kslack.api.methods.request.chat.ChatUpdateRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsHistoryRequest
import io.mverse.kslack.api.model.Attachment
import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.ResponseMetadata
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.IOException

class Slack_channels_chat_Test {

  internal var slack = io.mverse.kslack.Slack()

  @Test

  fun channels_threading() = runBlocking {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val channels = slack.channelsList(ChannelsListRequest(
        token = token,
        limit = 2,
        isExcludeArchived = true))

    assertThat(channels.ok, `is`(true))
    assertThat<ResponseMetadata>(channels.responseMetadata, `is`(notNullValue()))

    val channelId = channels.channels!![0].id

    val firstMessageCreation = slack.chatPostMessage(ChatPostMessageRequest(
        channel = channelId,
        token = token,
        text = "[thread] This is a test message posted by unit tests for jslack library",
        isReplyBroadcast = false))

    assertThat(firstMessageCreation.ok, `is`(true))

    val reply1 = slack.chatPostMessage(ChatPostMessageRequest(
        channel = channelId,
        token = token,
        asUser = false,
        text = "replied",
        threadTs = firstMessageCreation.ts
        //.replyBroadcast(true)
    ))
    assertThat(reply1.ok, `is`(true))

    val permalink = slack.chatGetPermalink(ChatGetPermalinkRequest(
        token = token,
        channel = channelId,
        messageTs = reply1.ts
    ))
    assertThat(permalink.ok, `is`(true))
    assertThat<String>(permalink.permalink, `is`(notNullValue()))

    val reply2 = slack.chatPostMessage(ChatPostMessageRequest(
        channel = channelId,
        token = token,
        asUser = true,
        text = "replied to " + permalink.permalink!!,
        threadTs = reply1.ts,
        isUnfurlLinks = true,
        isReplyBroadcast = true
    ))
    assertThat(reply2.ok, `is`(true))

    // Ideally, this message must contain an attachment which shows the preview for reply1
    // however, in this timing, Slack API doesn't return any attachments.
    assertThat<List<Attachment>>(reply2.message!!.attachments, `is`(nullValue()))

    // via channels.history
    run {
      val history = slack.channelsHistory(ChannelsHistoryRequest(
          token = token,
          channel = channelId
      ))
      assertThat(history.ok, `is`(true))

      val secondMessage = history.messages!![1]
      with(secondMessage) {
        assertThat<String>(type, `is`("message"))
        assertThat<String>(subtype, `is`("bot_message"))
        assertThat<List<Attachment>>(attachments, `is`(nullValue()))
        assertk.assert(root).isNull()
      }

      val firstMessage = history.messages!![0]
      with(firstMessage) {
        assertThat<String>(type, `is`("message"))
        assertThat<String>(subtype, `is`("thread_broadcast"))
      }

      // NOTE: the following assertions can fail due to Slack API's unstable response
      // this message must contain an attachment which shows the preview for reply1
      // TODO: as of 2018/05, these assertions fail.
      //            assertThat(latestMessage.getAttachments(), is(notNullValue()));
      //            assertThat(latestMessage.getAttachments().size(), is(1));
      //            assertThat(latestMessage.getRoot(), is(notNullValue()));
      //            assertThat(latestMessage.getRoot().getReplies().size(), is(2));
      //            assertThat(latestMessage.getRoot().getReplyCount(), is(2));
    }

    // via conversations.history
    run {
      val history = slack.conversationsHistory(ConversationsHistoryRequest(
          token = token,
          channel = channelId))
      assertThat(history.ok, `is`(true))

      with(history.messages!![1]) {
        assertThat<String>(type, `is`("message"))
        assertThat<String>(subtype, `is`("bot_message"))
        assertThat<List<Attachment>>(attachments, `is`(nullValue()))
        assertk.assert(root).isNull()
      }


      with(history.messages!![0]) {
        assertThat<String>(type, `is`("message"))
        assertThat<String>(subtype, `is`("thread_broadcast"))
      }

      // NOTE: the following assertions can fail due to Slack API's unstable response
      // this message must contain an attachment which shows the preview for reply1
      // TODO: as of August 2018, these assertions fail.
      //            assertThat(latestMessage.getAttachments(), is(notNullValue()));
      //            assertThat(latestMessage.getAttachments().size(), is(1));
      //            assertThat(latestMessage.getRoot(), is(notNullValue()));
      //            assertThat(latestMessage.getRoot().getReplies().size(), is(2));
      //            assertThat(latestMessage.getRoot().getReplyCount(), is(2));
    }
  }

  @Test
  fun chat_getPermalink() = runBlocking {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)
    val channels = slack.channelsList(ChannelsListRequest(
        token = token,
        isExcludeArchived = true
    ))
    assertThat(channels.ok, `is`(true))

    val channelId = channels.channels!![0].id

    val postResponse = slack.chatPostMessage(ChatPostMessageRequest(
        channel = channelId,
        token = token,
        text = "Hi, this is a test message from jSlack library's unit tests",
        isLinkNames = true
    ))
    assertThat(postResponse.ok, `is`(true))

    val permalink = slack.chatGetPermalink(ChatGetPermalinkRequest(
        token = token,
        channel = channelId,
        messageTs = postResponse.ts
    ))
    assertThat(permalink.ok, `is`(true))
    assertThat<String>(permalink.permalink, `is`(notNullValue()))
  }

  @Test

  fun channels_chat() = runBlocking {
    val token = System.getenv(Constants.SLACK_TEST_OAUTH_ACCESS_TOKEN)

    run {
      val response = slack.channelsList(
          ChannelsListRequest(token))
      assertThat(response.toString(), response.ok, `is`(true))
      assertThat<List<Channel>>(response.channels, `is`(notNullValue()))
    }

    val creationResponse = slack.channelsCreate(
        ChannelsCreateRequest(token = token, name = "test" + System.currentTimeMillis()))
    assertThat(creationResponse.ok, `is`(true))
    assertThat<Channel>(creationResponse.channel, `is`(notNullValue()))

    val channel = creationResponse.channel

    run {
      val response = slack.channelsInfo(
          ChannelsInfoRequest(token = token, channel = (channel!!.id)))
      assertThat(response.ok, `is`(true))
      val fetchedChannel = response.channel
      assertThat(fetchedChannel!!.isMember, `is`(true))
      assertThat(fetchedChannel.isGeneral, `is`(false))
      assertThat(fetchedChannel.isArchived, `is`(false))
    }

    run {
      val response = slack.channelsSetPurpose(
          ChannelsSetPurposeRequest(token = token, channel = (channel!!.id), purpose = ("purpose")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.channelsSetTopic(
          ChannelsSetTopicRequest(token = token, channel = (channel!!.id), topic = ("topic")))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.channelsHistory(
          ChannelsHistoryRequest(token = token, channel = (channel!!.id), count = (10)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val history = slack.channelsHistory(
          ChannelsHistoryRequest(token = token, channel = (channel!!.id), count = (1)))
      val threadTs = history.messages!![0].ts
      val response = slack.channelsReplies(
          ChannelsRepliesRequest(token = token, channel = (channel.id), threadTs = (threadTs)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val unfurlResponse = slack.chatUnfurl(ChatUnfurlRequest(
          token = token,
          channel = channel!!.id,
          unfurls = "http://www.example.com/"
      ))
      // TODO: valid test
      assertThat(unfurlResponse.ok, `is`(false))
      assertThat<String>(unfurlResponse.error, `is`("missing_ts"))
    }

    run {
      val response = slack.channelsKick(ChannelsKickRequest(
          token = token,
          channel = channel!!.id,
          user = channel.members!![0]
      ))
      // TODO: valid test
      assertThat(response.ok, `is`(false))
      assertThat<String>(response.error, `is`("cant_kick_self"))
    }

    run {
      val response = slack.channelsInvite(ChannelsInviteRequest(
          token = token,
          channel = channel!!.id,
          user = channel.members!![0]
      ))
      // TODO: valid test
      assertThat(response.ok, `is`(false))
      assertThat<String>(response.error, `is`("cant_invite_self"))
    }

    run {
      val response = slack.chatMeMessage(ChatMeMessageRequest(
          channel = channel!!.id,
          token = token,
          text = "Hello World! via chat.meMessage API"
      ))
      assertThat(response.ok, `is`(true))
    }

    run {
      val postResponse = slack.chatPostMessage(ChatPostMessageRequest(
          channel = channel!!.id,
          token = token,
          text = "@seratch Hello World! via chat.postMessage API",
          isLinkNames = true
      ))
      assertThat(postResponse.ok, `is`(true))

      val replyResponse1 = slack.chatPostMessage(ChatPostMessageRequest(
          channel = channel.id,
          token = token,
          text = "@seratch Replied via chat.postMessage API",
          isLinkNames = true,
          threadTs = postResponse.ts
          //.replyBroadcast(false)
      ))
      assertThat(replyResponse1.ok, `is`(true))

      val replyResponse2 = slack.chatPostMessage(ChatPostMessageRequest(
          channel = channel.id,
          token = token,
          text = "@seratch Replied via chat.postMessage API",
          isLinkNames = true,
          threadTs = postResponse.ts,
          isReplyBroadcast = true
      ))
      assertThat(replyResponse2.ok, `is`(true))

      val updateResponse = slack.chatUpdate(ChatUpdateRequest(
          channel = channel.id,
          token = token,
          ts = postResponse.ts,
          text = "Updated text",
          isLinkNames = false
      ))
      assertThat(updateResponse.ok, `is`(true))

      val deleteResponse = slack.chatDelete(ChatDeleteRequest(
          token = token,
          channel = channel.id,
          ts = postResponse.message!!.ts
      ))
      assertThat(deleteResponse.ok, `is`(true))
    }
    run {
      val response = slack.channelsLeave(ChannelsLeaveRequest(
          token = token,
          channel = channel!!.id
      ))
      assertThat(response.ok, `is`(true))
    }
    run {
      val response = slack.channelsJoin(ChannelsJoinRequest(
          token = token,
          name = channel!!.name
      ))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.channelsRename(ChannelsRenameRequest(
          token = token,
          channel = channel!!.id,
          name = channel.name + "-1"
      ))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.channelsArchive(
          ChannelsArchiveRequest(token = token, channel = (channel!!.id)))
      assertThat(response.ok, `is`(true))
    }

    run {
      val response = slack.channelsInfo(
          ChannelsInfoRequest(token = token, channel = (channel!!.id)))
      assertThat(response.ok, `is`(true))
      val fetchedChannel = response.channel
      assertThat(fetchedChannel!!.isMember, `is`(false))
      assertThat(fetchedChannel.isGeneral, `is`(false))
      assertThat(fetchedChannel.isArchived, `is`(true))
    }
  }
}