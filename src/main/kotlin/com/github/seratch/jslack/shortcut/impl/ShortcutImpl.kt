package com.github.seratch.jslack.shortcut.impl

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.methods.request.channels.ChannelsHistoryRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsListRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsAddRequest
import com.github.seratch.jslack.api.methods.request.search.SearchAllRequest
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsAddResponse
import com.github.seratch.jslack.api.methods.response.search.SearchAllResponse
import com.github.seratch.jslack.api.model.Attachment
import com.github.seratch.jslack.api.model.Channel
import com.github.seratch.jslack.api.model.Message
import com.github.seratch.jslack.shortcut.Shortcut
import com.github.seratch.jslack.shortcut.model.ApiToken
import com.github.seratch.jslack.shortcut.model.ChannelId
import com.github.seratch.jslack.shortcut.model.ChannelName
import com.github.seratch.jslack.shortcut.model.ReactionName
import java.util.*

data class ShortcutImpl(
    private val apiToken: ApiToken? = null,
    private val slack: Slack,
    private var channels: List<Channel> = listOf()) : Shortcut {

  override fun findChannelIdByName(name: ChannelName): Optional<ChannelId> {
    if (channels.isEmpty()) {
      updateChannelsCache()
    }
    return channels.stream()
        .filter { c -> c.name == name.value }
        .findFirst()
        .map { c -> ChannelId(c.id) }
  }

  override fun findChannelNameById(channelId: ChannelId): Optional<ChannelName> {
    return channels.stream()
        .filter { c -> c.id == channelId.value }
        .findFirst()
        .map { c -> ChannelName(c.name) }
  }

  override fun findRecentMessagesByName(name: ChannelName): List<Message> {
    val maybeChannelId = findChannelIdByName(name)
    if (maybeChannelId.isPresent) {
      val channelId = maybeChannelId.get()
      val response = slack.methods().channelsHistory(ChannelsHistoryRequest(
          token = apiToken!!.value,
          channel = channelId.value,
          count = 1000))
      return if (response.ok) {
        response.messages!!.map { message ->
          // channel in message can bt null in this case...
          message.copy(channel = message.channel ?: channelId.value)
        }
      } else {
        emptyList()
      }
    } else {
      return emptyList()
    }
  }

  override fun addReaction(message: Message, reactionName: ReactionName): ReactionsAddResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    return slack.methods().reactionsAdd(ReactionsAddRequest(
        token = apiToken.value,
        channel = message.channel,
        timestamp = message.ts,
        name = reactionName.value))
  }

  override fun search(query: String): SearchAllResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    return slack.methods().searchAll(SearchAllRequest(
        token = apiToken.value,
        query = query,
        count = 100))
  }

  override fun post(channel: ChannelName, text: String): ChatPostMessageResponse {
    return _post(channel, text, emptyList(), true)
  }

  override fun postAsBot(channel: ChannelName, text: String): ChatPostMessageResponse {
    return _post(channel, text, emptyList(), false)
  }

  override fun post(channel: ChannelName, text: String, attachments: List<Attachment>): ChatPostMessageResponse {
    return _post(channel, text, attachments, true)
  }

  override fun postAsBot(channel: ChannelName, text: String, attachments: List<Attachment>): ChatPostMessageResponse {
    return _post(channel, text, attachments, false)
  }

  private fun _post(channel: ChannelName, text: String, attachments: List<Attachment>, asUser: Boolean): ChatPostMessageResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    val channelId = findChannelIdByName(channel)
    return if (channelId.isPresent) {
      slack.methods().chatPostMessage(ChatPostMessageRequest(
          token = apiToken.value,
          asUser = asUser,
          channel = channelId.get().value,
          text = text,
          attachments = attachments))
    } else {
      throw IllegalStateException("Unknown channel: " + channel.value)
    }
  }

  override fun updateChannelsCache() {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    if (channels.isEmpty()) {
      val response = slack.methods().channelsList(ChannelsListRequest(token = apiToken.value))
      if (response.ok && response.channels != null) {
        channels = response.channels
      }
    }
  }
}
