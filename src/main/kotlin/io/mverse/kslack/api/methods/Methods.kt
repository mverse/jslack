@file:Suppress("ClassName")

package io.mverse.kslack.api.methods

// ------------------------------
// api
// ------------------------------

object api {
  const val test = "api.test"
}

// ------------------------------
// apps.permissions
// ------------------------------

object apps {
  object permissions {
    const val info = "apps.permissions.info"
    const val request = "apps.permissions.request"
  }
}

// ------------------------------
// auth
// ------------------------------

object auth {
  const val revoke = "auth.revoke"
  const val test = "auth.test"
}

// ------------------------------
// bots
// ------------------------------

object bots {
  const val info = "bots.info"
}

// ------------------------------
// channels
// ------------------------------

object channels {
  const val archive = "channels.archive"
  const val create = "channels.create"
  const val history = "channels.history"
  const val info = "channels.info"
  const val invite = "channels.invite"
  const val join = "channels.join"
  const val kick = "channels.kick"
  const val leave = "channels.leave"
  const val list = "channels.list"
  const val mark = "channels.mark"
  const val rename = "channels.rename"
  const val replies = "channels.replies"
  const val setPurpose = "channels.setPurpose"
  const val setTopic = "channels.setTopic"
  const val unarchive = "channels.unarchive"
}

// ------------------------------
// chat
// ------------------------------
object chat {
  const val delete = "chat.delete"
  const val getPermalink = "chat.getPermalink"
  const val meMessage = "chat.meMessage"
  const val postEphemeral = "chat.postEphemeral"
  const val postMessage = "chat.postMessage"
  const val unfurl = "chat.unfurl"
  const val update = "chat.update"
}

// ------------------------------
// conversations
// ------------------------------

object conversations {
  const val archive = "conversations.archive"
  const val close = "conversations.close"
  const val create = "conversations.create"
  const val history = "conversations.history"
  const val info = "conversations.info"
  const val invite = "conversations.invite"
  const val join = "conversations.join"
  const val kick = "conversations.kick"
  const val leave = "conversations.leave"
  const val list = "conversations.list"
  const val members = "conversations.members"
  const val open = "conversations.open"
  const val rename = "conversations.rename"
  const val replies = "conversations.replies"
  const val setPurpose = "conversations.setPurpose"
  const val setTopic = "conversations.setTopic"
  const val unarchive = "conversations.unarchive"
}

// ------------------------------
// dialog
// ------------------------------

object dialog {
  const val open = "dialog.open"
}

// ------------------------------
// dnd
// ------------------------------

object dnd {
  const val endDnd = "dnd.endDnd"
  const val endSnooze = "dnd.endSnooze"
  const val info = "dnd.info"
  const val setSnooze = "dnd.setSnooze"
  const val teamInfo = "dnd.teamInfo"
}

// ------------------------------
// emoji
// ------------------------------

object emoji {
  const val list = "emoji.list"
}

// ------------------------------
// files.comments
// ------------------------------

object files {
  object comments {
    const val add = "files.comments.add"
    const val delete = "files.comments.delete"
    const val edit = "files.comments.edit"
  }

  const val delete = "files.delete"
  const val info = "files.info"
  const val list = "files.list"
  const val revokePublicUrl = "files.revokePublicURL"
  const val sharedPublicUrl = "files.sharedPublicURL"
  const val upload = "files.upload"
}

// ------------------------------
// files
// ------------------------------

// ------------------------------
// groups
// ------------------------------
object groups {
  const val archive = "groups.archive"
  const val close = "groups.close"
  const val create = "groups.create"
  const val createChild = "groups.createChild"
  const val history = "groups.history"
  const val info = "groups.info"
  const val invite = "groups.invite"
  const val kick = "groups.kick"
  const val leave = "groups.leave"
  const val list = "groups.list"
  const val mark = "groups.mark"
  const val open = "groups.open"
  const val rename = "groups.rename"
  const val setPurpose = "groups.setPurpose"
  const val setTopic = "groups.setTopic"
  const val unarchive = "groups.unarchive"
  const val replies = "groups.replies"
}

// ------------------------------
// im
// ------------------------------
object im {
  const val close = "im.close"
  const val history = "im.history"
  const val list = "im.list"
  const val mark = "im.mark"
  const val open = "im.open"
  const val replies = "im.replies"
}

// ------------------------------
// migration
// ------------------------------

object migration {
  const val exchange = "migration.exchange"
}

// ------------------------------
// mpim
// ------------------------------

object mpim {
  const val close = "mpim.close"
  const val history = "mpim.history"
  const val list = "mpim.list"
  const val mark = "mpim.mark"
  const val open = "mpim.open"
  const val replies = "mpim.replies"
}

// ------------------------------
// oauth
// ------------------------------
object oauth {
  const val access = "oauth.access"
  const val token = "oauth.token"
}

// ------------------------------
// pins
// ------------------------------
object pins {
  const val add = "pins.add"
  const val list = "pins.list"
  const val remove = "pins.remove"
}

// ------------------------------
// reactions
// ------------------------------
object reactions {
  const val add = "reactions.add"
  const val get = "reactions.get"
  const val list = "reactions.list"
  const val remove = "reactions.remove"
}

// ------------------------------
// reminders
// ------------------------------

object reminders {
  const val add = "reminders.add"
  const val complete = "reminders.complete"
  const val delete = "reminders.delete"
  const val info = "reminders.info"
  const val list = "reminders.list"
}

// ------------------------------
// rtm
// ------------------------------

object rtm {
  const val connect = "rtm.connect"
  const val start = "rtm.start"
}

// ------------------------------
// search
// ------------------------------

object search {
  const val all = "search.all"
  const val files = "search.files"
  const val messages = "search.messages"
}

// ------------------------------
// stars
// ------------------------------

object stars {
  const val add = "stars.add"
  const val list = "stars.list"
  const val remove = "stars.remove"
}

// ------------------------------
// team
// ------------------------------

object team {
  const val accessLogs = "team.accessLogs"
  const val billableInfo = "team.billableInfo"
  const val info = "team.info"
  const val integrationLogs = "team.integrationLogs"

  object profile {
    const val get = "team.profile.get"
  }
}

// ------------------------------
// usergroups
// ------------------------------

object usergroups {
  const val create = "usergroups.create"
  const val disable = "usergroups.disable"
  const val enable = "usergroups.enable"
  const val list = "usergroups.list"
  const val update = "usergroups.update"

  // ------------------------------
  // usergroups.users
  // ------------------------------

  object users {
    const val list = "usergroups.users.list"
    const val update = "usergroups.users.update"
  }
}

// ------------------------------
// users
// ------------------------------
object users {
  const val conversations = "users.conversations"
  const val deletePhoto = "users.deletePhoto"
  const val getPresence = "users.getPresence"
  const val identity = "users.identity"
  const val info = "users.info"
  const val list = "users.list"
  const val lookupByEmail = "users.lookupByEmail"
  const val setActive = "users.setActive"
  const val setPhoto = "users.setPhoto"
  const val setPresence = "users.setPresence"

  // ------------------------------
  // users.profile
  // ------------------------------

  object profile {
    const val get = "users.profile.get"
    const val set = "users.profile.set"
  }
}

