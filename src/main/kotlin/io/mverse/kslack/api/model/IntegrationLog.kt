package io.mverse.kslack.api.model

data class IntegrationLog(

  val serviceId: String? = null,
  val serviceType: String? = null,
  val userId: String? = null,
  val userName: String? = null,
  val channel: String? = null,
  val date: Int? = null,
  val changeType: String? = null,
  val scope: String? = null)
