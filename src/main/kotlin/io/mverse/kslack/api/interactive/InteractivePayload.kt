package io.mverse.kslack.api.interactive

import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

interface InteractivePayload {
  val type: String
  val team: Team
  val user: User
  val channel: Channel
  val callbackId: String
  val actionTs: String?
  val messageTs: String?
}