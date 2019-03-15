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

data class ShortcutImpl(
    private val apiToken: ApiToken? = null,
    private val methods: MethodsClient,
    private var channels: List<Channel> = listOf()) : Shortcut {

  override suspend fun findChannelIdByName(name: ChannelName): ChannelId? {
    if (channels.isEmpty()) {
      updateChannelsCache()
    }
    return channels
        .filter { c -> c.name == name }
        .map { it.id }
        .firstOrNull()
  }

  override suspend fun findChannelNameById(channelId: ChannelId): ChannelName? {
    return channels
        .filter { c -> c.id == channelId }
        .map { it.name }
        .firstOrNull()
  }

  override suspend fun findRecentMessagesByName(name: ChannelName): List<Message> {
    val channelId = findChannelIdByName(name)
    return when (channelId) {
      null -> emptyList()
      else -> {
        val response = methods.channelsHistory(ChannelsHistoryRequest(
            token = apiToken,
            channel = channelId,
            count = 1000))
        if (response.ok) {
          response.messages!!.map { message ->
            // channel in message can bt null in this case...
            message.copy(channel = message.channel ?: channelId)
          }
        } else {
          emptyList()
        }
      }
    }
  }

  override suspend fun addReaction(message: Message, reactionName: ReactionName): ReactionsAddResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    return methods.reactionsAdd(ReactionsAddRequest(
        token = apiToken,
        channel = message.channel,
        timestamp = message.ts,
        name = reactionName))
  }

  override suspend fun search(query: String): SearchAllResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    return methods.searchAll(SearchAllRequest(
        token = apiToken,
        query = query,
        count = 100))
  }

  override suspend fun post(channel: ChannelName, text: String): ChatPostMessageResponse {
    return _post(channel, text, emptyList(), true)
  }

  override suspend fun postAsBot(channel: ChannelName, text: String): ChatPostMessageResponse {
    return _post(channel, text, emptyList(), false)
  }

  override suspend fun post(channel: ChannelName, text: String, attachments: List<Attachment>): ChatPostMessageResponse {
    return _post(channel, text, attachments, true)
  }

  override suspend fun postAsBot(channel: ChannelName, text: String, attachments: List<Attachment>): ChatPostMessageResponse {
    return _post(channel, text, attachments, false)
  }

  private suspend fun _post(channel: ChannelName, text: String, attachments: List<Attachment>, asUser: Boolean): ChatPostMessageResponse {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    val channelId = findChannelIdByName(channel)
        ?: throw IllegalStateException("Unknown channel: $channel")
    return methods.chatPostMessage(ChatPostMessageRequest(
        token = apiToken,
        asUser = asUser,
        channel = channelId,
        text = text,
        attachments = attachments))
  }

  override suspend fun updateChannelsCache() {
    val apiToken = apiToken ?: throw IllegalStateException("apiToken is absent")
    if (channels.isEmpty()) {
      val response = methods.channelsList(ChannelsListRequest(token = apiToken))
      if (response.ok && response.channels != null) {
        channels = response.channels
      }
    }
  }
}
