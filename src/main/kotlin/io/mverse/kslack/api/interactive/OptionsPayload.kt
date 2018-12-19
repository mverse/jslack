package io.mverse.kslack.api.interactive

import io.mverse.kslack.api.model.Channel
import io.mverse.kslack.api.model.Team
import io.mverse.kslack.api.model.User

interface OptionsPayload {
  val type: String
  val team: Team
  val user: User

  /**
   * The name of the field for which options are being requested
   */
  val name: String

  /**
   * The typed in value from the end-user
   */
  val value: String
  val channel: Channel
  val callbackId: String
  val actionTs: String?
  val messageTs: String?
  val triggerId: String?
}