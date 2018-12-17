package io.mverse.kslack.shortcut.impl

import io.mverse.kslack.api.methods.MethodsClient
import io.mverse.kslack.api.methods.request.channels.ChannelsHistoryRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsAddRequest
import io.mverse.kslack.api.methods.request.search.SearchAllRequest
import io.mverse.kslack.api.methods.response.chat.ChatPostMessageResponse
import io.mverse.kslack.api.methods.response.reactions.ReactionsAddResponse
import io.mverse.kslack.api.methods.response.search.SearchAllResponse
import io.mverse.kslack.api.model.Attachment
import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Message
import io.mverse.kslack.shortcut.Shortcut
import io.mverse.kslack.shortcut.model.ApiToken
import io.mverse.kslack.shortcut.model.ChannelId
import io.mverse.kslack.shortcut.model.ChannelName
import io.mverse.kslack.shortcut.model.ReactionName
import java.util.*

data class ShortcutImpl(
    private val apiToken: ApiToken? = null,
    private val methods: MethodsClient,
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
      val response = methods.channelsHistory(ChannelsHistoryRequest(
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
    return methods.reactionsAdd(ReactionsAddRequest(
        token = apiToken.value,
        channel = message.channel,
        timestamp = message.ts,
        name = reactionName.value))
  }

  override fun search(query: String): SearchAllResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    return methods.searchAll(SearchAllRequest(
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
      methods.chatPostMessage(ChatPostMessageRequest(
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
      val response = methods.channelsList(ChannelsListRequest(token = apiToken.value))
      if (response.ok && response.channels != null) {
        channels = response.channels
      }
    }
  }
}