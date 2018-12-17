package io.mverse.kslack.api.methods.response.users

import io.mverse.kslack.api.methods.SlackApiResponse
import com.google.gson.annotations.SerializedName

data class UsersIdentityResponse(

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,
    val user: User? = null,
    val team: Team? = null) : SlackApiResponse {

  class User(
    val name: String? = null,
    val id: String? = null,
    val email: String? = null,
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
    val image512: String? = null)

  class Team(
      val name: String? = null,
      val id: String? = null)
}
