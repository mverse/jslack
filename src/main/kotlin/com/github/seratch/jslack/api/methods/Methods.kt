package com.github.seratch.jslack.api.methods

object Methods {

  // ------------------------------
  // api
  // ------------------------------

  const val API_TEST = "api.test"

  // ------------------------------
  // apps.permissions
  // ------------------------------

  const val APPS_PERMISSIONS_INFO = "apps.permissions.info"
  const val APPS_PERMISSIONS_REQUEST = "apps.permissions.request"

  // ------------------------------
  // auth
  // ------------------------------

  const val AUTH_REVOKE = "auth.revoke"
  const val AUTH_TEST = "auth.test"

  // ------------------------------
  // bots
  // ------------------------------

  const val BOTS_INFO = "bots.info"

  // ------------------------------
  // channels
  // ------------------------------

  const val CHANNELS_ARCHIVE = "channels.archive"
  const val CHANNELS_CREATE = "channels.create"
  const val CHANNELS_HISTORY = "channels.history"
  const val CHANNELS_INFO = "channels.info"
  const val CHANNELS_INVITE = "channels.invite"
  const val CHANNELS_JOIN = "channels.join"
  const val CHANNELS_KICK = "channels.kick"
  const val CHANNELS_LEAVE = "channels.leave"
  const val CHANNELS_LIST = "channels.list"
  const val CHANNELS_MARK = "channels.mark"
  const val CHANNELS_RENAME = "channels.rename"
  const val CHANNELS_REPLIES = "channels.replies"
  const val CHANNELS_SET_PURPOSE = "channels.setPurpose"
  const val CHANNELS_SET_TOPIC = "channels.setTopic"
  const val CHANNELS_UNARCHIVE = "channels.unarchive"

  // ------------------------------
  // chat
  // ------------------------------

  const val CHAT_DELETE = "chat.delete"
  const val CHAT_GET_PERMALINK = "chat.getPermalink"
  const val CHAT_ME_MESSAGE = "chat.meMessage"
  const val CHAT_POST_EPHEMERAL = "chat.postEphemeral"
  const val CHAT_POST_MESSAGE = "chat.postMessage"
  const val CHAT_UNFURL = "chat.unfurl"
  const val CHAT_UPDATE = "chat.update"

  // ------------------------------
  // conversations
  // ------------------------------

  const val CONVERSATIONS_ARCHIVE = "conversations.archive"
  const val CONVERSATIONS_CLOSE = "conversations.close"
  const val CONVERSATIONS_CREATE = "conversations.create"
  const val CONVERSATIONS_HISTORY = "conversations.history"
  const val CONVERSATIONS_INFO = "conversations.info"
  const val CONVERSATIONS_INVITE = "conversations.invite"
  const val CONVERSATIONS_JOIN = "conversations.join"
  const val CONVERSATIONS_KICK = "conversations.kick"
  const val CONVERSATIONS_LEAVE = "conversations.leave"
  const val CONVERSATIONS_LIST = "conversations.list"
  const val CONVERSATIONS_MEMBERS = "conversations.members"
  const val CONVERSATIONS_OPEN = "conversations.open"
  const val CONVERSATIONS_RENAME = "conversations.rename"
  const val CONVERSATIONS_REPLIES = "conversations.replies"
  const val CONVERSATIONS_SET_PURPOSE = "conversations.setPurpose"
  const val CONVERSATIONS_SET_TOPIC = "conversations.setTopic"
  const val CONVERSATIONS_UNARCHIVE = "conversations.unarchive"

  // ------------------------------
  // dialog
  // ------------------------------

  const val DIALOG_OPEN = "dialog.open"

  // ------------------------------
  // dnd
  // ------------------------------

  const val DND_END_DND = "dnd.endDnd"
  const val DND_END_SNOOZE = "dnd.endSnooze"
  const val DND_INFO = "dnd.info"
  const val DND_SET_SNOOZE = "dnd.setSnooze"
  const val DND_TEAM_INFO = "dnd.teamInfo"

  // ------------------------------
  // emoji
  // ------------------------------

  const val EMOJI_LIST = "emoji.list"

  // ------------------------------
  // files.comments
  // ------------------------------

  const val FILES_COMMENTS_ADD = "files.comments.add"
  const val FILES_COMMENTS_DELETE = "files.comments.delete"
  const val FILES_COMMENTS_EDIT = "files.comments.edit"

  // ------------------------------
  // files
  // ------------------------------

  const val FILES_DELETE = "files.delete"
  const val FILES_INFO = "files.info"
  const val FILES_LIST = "files.list"
  const val FILES_REVOKE_PUBLIC_URL = "files.revokePublicURL"
  const val FILES_SHARED_PUBLIC_URL = "files.sharedPublicURL"
  const val FILES_UPLOAD = "files.upload"

  // ------------------------------
  // groups
  // ------------------------------

  const val GROUPS_ARCHIVE = "groups.archive"
  const val GROUPS_CLOSE = "groups.close"
  const val GROUPS_CREATE = "groups.create"
  const val GROUPS_CREATE_CHILD = "groups.createChild"
  const val GROUPS_HISTORY = "groups.history"
  const val GROUPS_INFO = "groups.info"
  const val GROUPS_INVITE = "groups.invite"
  const val GROUPS_KICK = "groups.kick"
  const val GROUPS_LEAVE = "groups.leave"
  const val GROUPS_LIST = "groups.list"
  const val GROUPS_MARK = "groups.mark"
  const val GROUPS_OPEN = "groups.open"
  const val GROUPS_RENAME = "groups.rename"
  const val GROUPS_SET_PURPOSE = "groups.setPurpose"
  const val GROUPS_SET_TOPIC = "groups.setTopic"
  const val GROUPS_UNARCHIVE = "groups.unarchive"
  const val GROUPS_REPLIES = "groups.replies"

  // ------------------------------
  // im
  // ------------------------------

  const val IM_CLOSE = "im.close"
  const val IM_HISTORY = "im.history"
  const val IM_LIST = "im.list"
  const val IM_MARK = "im.mark"
  const val IM_OPEN = "im.open"
  const val IM_REPLIES = "im.replies"

  // ------------------------------
  // migration
  // ------------------------------

  const val MIGRATION_EXCHANGE = "migration.exchange"

  // ------------------------------
  // mpim
  // ------------------------------

  const val MPIM_CLOSE = "mpim.close"
  const val MPIM_HISTORY = "mpim.history"
  const val MPIM_LIST = "mpim.list"
  const val MPIM_MARK = "mpim.mark"
  const val MPIM_OPEN = "mpim.open"
  const val MPIM_REPLIES = "mpim.replies"

  // ------------------------------
  // oauth
  // ------------------------------

  const val OAUTH_ACCESS = "oauth.access"
  const val OAUTH_TOKEN = "oauth.token"

  // ------------------------------
  // pins
  // ------------------------------

  const val PINS_ADD = "pins.add"
  const val PINS_LIST = "pins.list"
  const val PINS_REMOVE = "pins.remove"

  // ------------------------------
  // reactions
  // ------------------------------

  const val REACTIONS_ADD = "reactions.add"
  const val REACTIONS_GET = "reactions.get"
  const val REACTIONS_LIST = "reactions.list"
  const val REACTIONS_REMOVE = "reactions.remove"

  // ------------------------------
  // reminders
  // ------------------------------

  const val REMINDERS_ADD = "reminders.add"
  const val REMINDERS_COMPLETE = "reminders.complete"
  const val REMINDERS_DELETE = "reminders.delete"
  const val REMINDERS_INFO = "reminders.info"
  const val REMINDERS_LIST = "reminders.list"

  // ------------------------------
  // rtm
  // ------------------------------

  const val RTM_CONNECT = "rtm.connect"
  const val RTM_START = "rtm.start"

  // ------------------------------
  // search
  // ------------------------------

  const val SEARCH_ALL = "search.all"
  const val SEARCH_FILES = "search.files"
  const val SEARCH_MESSAGES = "search.messages"

  // ------------------------------
  // stars
  // ------------------------------

  const val STARS_ADD = "stars.add"
  const val STARS_LIST = "stars.list"
  const val STARS_REMOVE = "stars.remove"

  // ------------------------------
  // team
  // ------------------------------

  const val TEAM_ACCESS_LOGS = "team.accessLogs"
  const val TEAM_BILLABLE_INFO = "team.billableInfo"
  const val TEAM_INFO = "team.info"
  const val TEAM_INTEGRATION_LOGS = "team.integrationLogs"

  // ------------------------------
  // team.profile
  // ------------------------------

  const val TEAM_PROFILE_GET = "team.profile.get"

  // ------------------------------
  // usergroups
  // ------------------------------

  const val USERGROUPS_CREATE = "usergroups.create"
  const val USERGROUPS_DISABLE = "usergroups.disable"
  const val USERGROUPS_ENABLE = "usergroups.enable"
  const val USERGROUPS_LIST = "usergroups.list"
  const val USERGROUPS_UPDATE = "usergroups.update"

  // ------------------------------
  // usergroups.users
  // ------------------------------

  const val USERGROUPS_USERS_LIST = "usergroups.users.list"
  const val USERGROUPS_USERS_UPDATE = "usergroups.users.update"

  // ------------------------------
  // users
  // ------------------------------

  const val USERS_CONVERSATIONS = "users.conversations"
  const val USERS_DELETE_PHOTO = "users.deletePhoto"
  const val USERS_GET_PRESENCE = "users.getPresence"
  const val USERS_IDENTITY = "users.identity"
  const val USERS_INFO = "users.info"
  const val USERS_LIST = "users.list"
  const val USERS_LOOKUP_BY_EMAIL = "users.lookupByEmail"
  const val USERS_SET_ACTIVE = "users.setActive"
  const val USERS_SET_PHOTO = "users.setPhoto"
  const val USERS_SET_PRESENCE = "users.setPresence"

  // ------------------------------
  // users.profile
  // ------------------------------

  const val USERS_PROFILE_GET = "users.profile.get"
  const val USERS_PROFILE_SET = "users.profile.set"
}
