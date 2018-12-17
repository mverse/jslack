package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * - https://api.slack.com/types/user
 * - https://api.slack.com/changelog/2017-09-the-one-about-usernames
 */

data class User(

  val id: String? = null,
  val teamId: String? = null,
  val name: String? = null,
  val isDeleted: Boolean = false,
  val color: String? = null,
  val realName: String? = null,
  val tz: String? = null,
  val tzLabel: String? = null,
  val tzOffset: Int? = null,
  val profile: Profile? = null,
  @SerializedName("is_admin")
  val isAdmin: Boolean = false,
  @SerializedName("is_owner")
  val isOwner: Boolean = false,
  @SerializedName("is_primary_owner")
  val isPrimaryOwner: Boolean = false,
  @SerializedName("is_restricted")
  val isRestricted: Boolean = false,
  @SerializedName("is_ultra_restricted")
  val isUltraRestricted: Boolean = false,
  @SerializedName("is_bot")
  val isBot: Boolean = false,
  @SerializedName("is_stranger")
  val isStranger: Boolean = false,
  @SerializedName("is_app_user")
  val isAppUser: Boolean = false,
  val updated: Long? = null,
  val isHas2fa: Boolean = false,
  val twoFactorType: String? = null,
  val isHasFiles: Boolean = false,
  val locale: String? = null) {

  data class Profile(

      val avatarHash: String? = null,
      val statusText: String? = null,
      val statusTextCanonical: String? = null,
      val statusEmoji: String? = null,
      val statusExpiration: Long? = null,

      val displayName: String? = null,
      val displayNameNormalized: String? = null,
      val realName: String? = null,
      val realNameNormalized: String? = null,
      val botId: String? = null,

      val title: String? = null,
      val email: String? = null,
      val skype: String? = null,
      val phone: String? = null,
      val team: String? = null,

      val apiAppId: String? = null,
      val isAlwaysActive: Boolean = false,

      @SerializedName("image_24")
      val image24: String? = null,
      @SerializedName("image_32")
      val image32: String? = null,
      @SerializedName("image_48")
      val image48: String? = null,
      @SerializedName("image_72")
      val image72: String? = null,
      @SerializedName("image_192")
      val image192: String? = null,
      @SerializedName("image_512")
      val image512: String? = null,
      @SerializedName("image_1024")
      val image1024: String? = null,
      val imageOriginal: String? = null,
      @SerializedName("is_custom_image")
      val isCustomImage: Boolean = false,

      val fields: Map<String, Field>? = null,

      var firstName: String? = null,
      var lastName: String? = null) {

    data class Field(
        val value: String? = null,
        val alt: String? = null,
        val label: String? = null)
  }
}

