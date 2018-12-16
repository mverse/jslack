package com.github.seratch.jslack.shortcut

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsAddResponse
import com.github.seratch.jslack.api.methods.response.search.SearchAllResponse
import com.github.seratch.jslack.api.model.Attachment
import com.github.seratch.jslack.api.model.Message
import com.github.seratch.jslack.shortcut.model.ChannelId
import com.github.seratch.jslack.shortcut.model.ChannelName
import com.github.seratch.jslack.shortcut.model.ReactionName
import java.io.IOException
import java.util.*

/**
 * Shortcut is an original API provided by this library.
 * As the name tells you, the module provides you more handy APIs than the official API methods.
 */
interface Shortcut {

  /**
   * Shortcut internally has a cache for channels API response. This method refreshes the cache immediately.
   */

  fun updateChannelsCache()

  /**
   * Returns ChannelId corresponding to a given channel name if exists.
   */

  fun findChannelIdByName(name: ChannelName): Optional<ChannelId>

  /**
   * Returns a channel's human readable name corresponding to a given channel id if exists.
   */
  fun findChannelNameById(channelId: ChannelId): Optional<ChannelName>

  /**
   * Returns a list of messages in the channel a given name matches.
   */

  fun findRecentMessagesByName(name: ChannelName): List<Message>

  /**
   * Adds a reaction to a specified message.
   */

  fun addReaction(message: Message, reactionName: ReactionName): ReactionsAddResponse

  /**
   * Returns search result by a given query.
   */

  fun search(query: String): SearchAllResponse

  /**
   * Posts a message to a given channel.
   */

  fun post(channel: ChannelName, text: String): ChatPostMessageResponse


  fun postAsBot(channel: ChannelName, text: String): ChatPostMessageResponse

  /**
   * Posts a message to a given channel.
   */

  fun post(channel: ChannelName, text: String, attachments: List<Attachment>): ChatPostMessageResponse


  fun postAsBot(channel: ChannelName, text: String, attachments: List<Attachment>): ChatPostMessageResponse
}
