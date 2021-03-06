package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

data class Team(
    val id: String,
    val name: String? = null,
    val domain: String? = null,
    val emailDomain: String? = null,
    val icon: TeamIcon? = null) {

  data class Profile(
      val id: String,
      val ordering: Int? = null,
      val label: String? = null,
      val hint: String? = null,
      val type: String? = null,
      val possibleValues: List<String>? = null,
      val options: ProfileOptions? = null)

  data class ProfileOptions(
      @SerializedName("is_protected")
      var isProtected: Boolean = false)
}
