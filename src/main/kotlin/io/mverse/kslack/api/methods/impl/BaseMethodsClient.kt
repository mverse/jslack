@file:Suppress("EXPERIMENTAL_API_USAGE")

package io.mverse.kslack.api.methods.impl

import com.google.gson.GsonBuilder
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.FormBuilder
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.append
import io.ktor.client.request.forms.formData
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.ContentType.Image
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.Parameters
import io.ktor.http.ParametersBuilder
import io.ktor.http.takeFrom
import io.mverse.kslack.api.methods.MethodsClient
import io.mverse.kslack.api.methods.SlackApiRequest
import io.mverse.kslack.api.methods.api
import io.mverse.kslack.api.methods.apps
import io.mverse.kslack.api.methods.auth
import io.mverse.kslack.api.methods.bots
import io.mverse.kslack.api.methods.channels
import io.mverse.kslack.api.methods.chat
import io.mverse.kslack.api.methods.conversations
import io.mverse.kslack.api.methods.dialog
import io.mverse.kslack.api.methods.dnd
import io.mverse.kslack.api.methods.emoji
import io.mverse.kslack.api.methods.files
import io.mverse.kslack.api.methods.groups
import io.mverse.kslack.api.methods.im
import io.mverse.kslack.api.methods.migration
import io.mverse.kslack.api.methods.mpim
import io.mverse.kslack.api.methods.oauth
import io.mverse.kslack.api.methods.pins
import io.mverse.kslack.api.methods.reactions
import io.mverse.kslack.api.methods.reminders
import io.mverse.kslack.api.methods.request.api.ApiTestRequest
import io.mverse.kslack.api.methods.request.apps.permissions.AppsPermissionsInfoRequest
import io.mverse.kslack.api.methods.request.apps.permissions.AppsPermissionsRequestRequest
import io.mverse.kslack.api.methods.request.auth.AuthRevokeRequest
import io.mverse.kslack.api.methods.request.auth.AuthTestRequest
import io.mverse.kslack.api.methods.request.bots.BotsInfoRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsArchiveRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsCreateRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsHistoryRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsInfoRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsInviteRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsJoinRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsKickRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsLeaveRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsListRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsMarkRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsRenameRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsRepliesRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsSetPurposeRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsSetTopicRequest
import io.mverse.kslack.api.methods.request.channels.ChannelsUnarchiveRequest
import io.mverse.kslack.api.methods.request.chat.ChatDeleteRequest
import io.mverse.kslack.api.methods.request.chat.ChatGetPermalinkRequest
import io.mverse.kslack.api.methods.request.chat.ChatMeMessageRequest
import io.mverse.kslack.api.methods.request.chat.ChatPostEphemeralRequest
import io.mverse.kslack.api.methods.request.chat.ChatPostMessageRequest
import io.mverse.kslack.api.methods.request.chat.ChatUnfurlRequest
import io.mverse.kslack.api.methods.request.chat.ChatUpdateRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsArchiveRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsCloseRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsCreateRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsHistoryRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsInfoRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsInviteRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsJoinRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsKickRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsLeaveRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsListRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsMembersRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsOpenRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsRenameRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsRepliesRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsSetPurposeRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsSetTopicRequest
import io.mverse.kslack.api.methods.request.conversations.ConversationsUnarchiveRequest
import io.mverse.kslack.api.methods.request.dialog.DialogOpenRequest
import io.mverse.kslack.api.methods.request.dnd.DndEndDndRequest
import io.mverse.kslack.api.methods.request.dnd.DndEndSnoozeRequest
import io.mverse.kslack.api.methods.request.dnd.DndInfoRequest
import io.mverse.kslack.api.methods.request.dnd.DndSetSnoozeRequest
import io.mverse.kslack.api.methods.request.dnd.DndTeamInfoRequest
import io.mverse.kslack.api.methods.request.emoji.EmojiListRequest
import io.mverse.kslack.api.methods.request.files.FilesDeleteRequest
import io.mverse.kslack.api.methods.request.files.FilesInfoRequest
import io.mverse.kslack.api.methods.request.files.FilesListRequest
import io.mverse.kslack.api.methods.request.files.FilesRevokePublicURLRequest
import io.mverse.kslack.api.methods.request.files.FilesSharedPublicURLRequest
import io.mverse.kslack.api.methods.request.files.FilesUploadRequest
import io.mverse.kslack.api.methods.request.files.comments.FilesCommentsAddRequest
import io.mverse.kslack.api.methods.request.files.comments.FilesCommentsDeleteRequest
import io.mverse.kslack.api.methods.request.files.comments.FilesCommentsEditRequest
import io.mverse.kslack.api.methods.request.groups.GroupsArchiveRequest
import io.mverse.kslack.api.methods.request.groups.GroupsCloseRequest
import io.mverse.kslack.api.methods.request.groups.GroupsCreateChildRequest
import io.mverse.kslack.api.methods.request.groups.GroupsCreateRequest
import io.mverse.kslack.api.methods.request.groups.GroupsHistoryRequest
import io.mverse.kslack.api.methods.request.groups.GroupsInfoRequest
import io.mverse.kslack.api.methods.request.groups.GroupsInviteRequest
import io.mverse.kslack.api.methods.request.groups.GroupsKickRequest
import io.mverse.kslack.api.methods.request.groups.GroupsLeaveRequest
import io.mverse.kslack.api.methods.request.groups.GroupsListRequest
import io.mverse.kslack.api.methods.request.groups.GroupsMarkRequest
import io.mverse.kslack.api.methods.request.groups.GroupsOpenRequest
import io.mverse.kslack.api.methods.request.groups.GroupsRenameRequest
import io.mverse.kslack.api.methods.request.groups.GroupsRepliesRequest
import io.mverse.kslack.api.methods.request.groups.GroupsSetPurposeRequest
import io.mverse.kslack.api.methods.request.groups.GroupsSetTopicRequest
import io.mverse.kslack.api.methods.request.groups.GroupsUnarchiveRequest
import io.mverse.kslack.api.methods.request.im.ImCloseRequest
import io.mverse.kslack.api.methods.request.im.ImHistoryRequest
import io.mverse.kslack.api.methods.request.im.ImListRequest
import io.mverse.kslack.api.methods.request.im.ImMarkRequest
import io.mverse.kslack.api.methods.request.im.ImOpenRequest
import io.mverse.kslack.api.methods.request.im.ImRepliesRequest
import io.mverse.kslack.api.methods.request.migration.MigrationExchangeRequest
import io.mverse.kslack.api.methods.request.mpim.MpimCloseRequest
import io.mverse.kslack.api.methods.request.mpim.MpimHistoryRequest
import io.mverse.kslack.api.methods.request.mpim.MpimListRequest
import io.mverse.kslack.api.methods.request.mpim.MpimMarkRequest
import io.mverse.kslack.api.methods.request.mpim.MpimOpenRequest
import io.mverse.kslack.api.methods.request.mpim.MpimRepliesRequest
import io.mverse.kslack.api.methods.request.oauth.OAuthAccessRequest
import io.mverse.kslack.api.methods.request.oauth.OAuthTokenRequest
import io.mverse.kslack.api.methods.request.pins.PinsAddRequest
import io.mverse.kslack.api.methods.request.pins.PinsListRequest
import io.mverse.kslack.api.methods.request.pins.PinsRemoveRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsAddRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsGetRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsListRequest
import io.mverse.kslack.api.methods.request.reactions.ReactionsRemoveRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersAddRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersCompleteRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersDeleteRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersInfoRequest
import io.mverse.kslack.api.methods.request.reminders.RemindersListRequest
import io.mverse.kslack.api.methods.request.rtm.RTMConnectRequest
import io.mverse.kslack.api.methods.request.rtm.RTMStartRequest
import io.mverse.kslack.api.methods.request.search.SearchAllRequest
import io.mverse.kslack.api.methods.request.search.SearchFilesRequest
import io.mverse.kslack.api.methods.request.search.SearchMessagesRequest
import io.mverse.kslack.api.methods.request.stars.StarsAddRequest
import io.mverse.kslack.api.methods.request.stars.StarsListRequest
import io.mverse.kslack.api.methods.request.stars.StarsRemoveRequest
import io.mverse.kslack.api.methods.request.team.TeamAccessLogsRequest
import io.mverse.kslack.api.methods.request.team.TeamBillableInfoRequest
import io.mverse.kslack.api.methods.request.team.TeamInfoRequest
import io.mverse.kslack.api.methods.request.team.TeamIntegrationLogsRequest
import io.mverse.kslack.api.methods.request.team.profile.TeamProfileGetRequest
import io.mverse.kslack.api.methods.request.usergroups.UsergroupsCreateRequest
import io.mverse.kslack.api.methods.request.usergroups.UsergroupsDisableRequest
import io.mverse.kslack.api.methods.request.usergroups.UsergroupsEnableRequest
import io.mverse.kslack.api.methods.request.usergroups.UsergroupsListRequest
import io.mverse.kslack.api.methods.request.usergroups.UsergroupsUpdateRequest
import io.mverse.kslack.api.methods.request.usergroups.users.UsergroupUsersListRequest
import io.mverse.kslack.api.methods.request.usergroups.users.UsergroupUsersUpdateRequest
import io.mverse.kslack.api.methods.request.users.UsersConversationsRequest
import io.mverse.kslack.api.methods.request.users.UsersDeletePhotoRequest
import io.mverse.kslack.api.methods.request.users.UsersGetPresenceRequest
import io.mverse.kslack.api.methods.request.users.UsersIdentityRequest
import io.mverse.kslack.api.methods.request.users.UsersInfoRequest
import io.mverse.kslack.api.methods.request.users.UsersListRequest
import io.mverse.kslack.api.methods.request.users.UsersLookupByEmailRequest
import io.mverse.kslack.api.methods.request.users.UsersSetActiveRequest
import io.mverse.kslack.api.methods.request.users.UsersSetPhotoRequest
import io.mverse.kslack.api.methods.request.users.UsersSetPresenceRequest
import io.mverse.kslack.api.methods.request.users.profile.UsersProfileGetRequest
import io.mverse.kslack.api.methods.request.users.profile.UsersProfileSetRequest
import io.mverse.kslack.api.methods.response.api.ApiTestResponse
import io.mverse.kslack.api.methods.response.apps.permissions.AppsPermissionsInfoResponse
import io.mverse.kslack.api.methods.response.apps.permissions.AppsPermissionsRequestResponse
import io.mverse.kslack.api.methods.response.auth.AuthRevokeResponse
import io.mverse.kslack.api.methods.response.auth.AuthTestResponse
import io.mverse.kslack.api.methods.response.bots.BotsInfoResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsArchiveResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsCreateResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsHistoryResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsInfoResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsInviteResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsJoinResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsKickResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsLeaveResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsListResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsMarkResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsRenameResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsRepliesResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsSetPurposeResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsSetTopicResponse
import io.mverse.kslack.api.methods.response.channels.ChannelsUnarchiveResponse
import io.mverse.kslack.api.methods.response.channels.UsersLookupByEmailResponse
import io.mverse.kslack.api.methods.response.chat.ChatDeleteResponse
import io.mverse.kslack.api.methods.response.chat.ChatGetPermalinkResponse
import io.mverse.kslack.api.methods.response.chat.ChatMeMessageResponse
import io.mverse.kslack.api.methods.response.chat.ChatPostEphemeralResponse
import io.mverse.kslack.api.methods.response.chat.ChatPostMessageResponse
import io.mverse.kslack.api.methods.response.chat.ChatUnfurlResponse
import io.mverse.kslack.api.methods.response.chat.ChatUpdateResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsArchiveResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsCloseResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsCreateResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsHistoryResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsInfoResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsInviteResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsJoinResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsKickResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsLeaveResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsListResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsMembersResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsOpenResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsRenameResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsRepliesResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsSetPurposeResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsSetTopicResponse
import io.mverse.kslack.api.methods.response.conversations.ConversationsUnarchiveResponse
import io.mverse.kslack.api.methods.response.dialog.DialogOpenResponse
import io.mverse.kslack.api.methods.response.dnd.DndEndDndResponse
import io.mverse.kslack.api.methods.response.dnd.DndEndSnoozeResponse
import io.mverse.kslack.api.methods.response.dnd.DndInfoResponse
import io.mverse.kslack.api.methods.response.dnd.DndSetSnoozeResponse
import io.mverse.kslack.api.methods.response.dnd.DndTeamInfoResponse
import io.mverse.kslack.api.methods.response.emoji.EmojiListResponse
import io.mverse.kslack.api.methods.response.files.FilesDeleteResponse
import io.mverse.kslack.api.methods.response.files.FilesInfoResponse
import io.mverse.kslack.api.methods.response.files.FilesListResponse
import io.mverse.kslack.api.methods.response.files.FilesRevokePublicURLResponse
import io.mverse.kslack.api.methods.response.files.FilesSharedPublicURLResponse
import io.mverse.kslack.api.methods.response.files.FilesUploadResponse
import io.mverse.kslack.api.methods.response.files.comments.FilesCommentsAddResponse
import io.mverse.kslack.api.methods.response.files.comments.FilesCommentsDeleteResponse
import io.mverse.kslack.api.methods.response.files.comments.FilesCommentsEditResponse
import io.mverse.kslack.api.methods.response.groups.GroupsArchiveResponse
import io.mverse.kslack.api.methods.response.groups.GroupsCloseResponse
import io.mverse.kslack.api.methods.response.groups.GroupsCreateChildResponse
import io.mverse.kslack.api.methods.response.groups.GroupsCreateResponse
import io.mverse.kslack.api.methods.response.groups.GroupsHistoryResponse
import io.mverse.kslack.api.methods.response.groups.GroupsInfoResponse
import io.mverse.kslack.api.methods.response.groups.GroupsInviteResponse
import io.mverse.kslack.api.methods.response.groups.GroupsKickResponse
import io.mverse.kslack.api.methods.response.groups.GroupsLeaveResponse
import io.mverse.kslack.api.methods.response.groups.GroupsListResponse
import io.mverse.kslack.api.methods.response.groups.GroupsMarkResponse
import io.mverse.kslack.api.methods.response.groups.GroupsOpenResponse
import io.mverse.kslack.api.methods.response.groups.GroupsRenameResponse
import io.mverse.kslack.api.methods.response.groups.GroupsRepliesResponse
import io.mverse.kslack.api.methods.response.groups.GroupsSetPurposeResponse
import io.mverse.kslack.api.methods.response.groups.GroupsSetTopicResponse
import io.mverse.kslack.api.methods.response.groups.GroupsUnarchiveResponse
import io.mverse.kslack.api.methods.response.im.ImCloseResponse
import io.mverse.kslack.api.methods.response.im.ImHistoryResponse
import io.mverse.kslack.api.methods.response.im.ImListResponse
import io.mverse.kslack.api.methods.response.im.ImMarkResponse
import io.mverse.kslack.api.methods.response.im.ImOpenResponse
import io.mverse.kslack.api.methods.response.im.ImRepliesResponse
import io.mverse.kslack.api.methods.response.migration.MigrationExchangeResponse
import io.mverse.kslack.api.methods.response.mpim.MpimCloseResponse
import io.mverse.kslack.api.methods.response.mpim.MpimHistoryResponse
import io.mverse.kslack.api.methods.response.mpim.MpimListResponse
import io.mverse.kslack.api.methods.response.mpim.MpimMarkResponse
import io.mverse.kslack.api.methods.response.mpim.MpimOpenResponse
import io.mverse.kslack.api.methods.response.mpim.MpimRepliesResponse
import io.mverse.kslack.api.methods.response.oauth.OAuthAccessResponse
import io.mverse.kslack.api.methods.response.oauth.OAuthTokenResponse
import io.mverse.kslack.api.methods.response.pins.PinsAddResponse
import io.mverse.kslack.api.methods.response.pins.PinsListResponse
import io.mverse.kslack.api.methods.response.pins.PinsRemoveResponse
import io.mverse.kslack.api.methods.response.reactions.ReactionsAddResponse
import io.mverse.kslack.api.methods.response.reactions.ReactionsGetResponse
import io.mverse.kslack.api.methods.response.reactions.ReactionsListResponse
import io.mverse.kslack.api.methods.response.reactions.ReactionsRemoveResponse
import io.mverse.kslack.api.methods.response.reminders.RemindersAddResponse
import io.mverse.kslack.api.methods.response.reminders.RemindersCompleteResponse
import io.mverse.kslack.api.methods.response.reminders.RemindersDeleteResponse
import io.mverse.kslack.api.methods.response.reminders.RemindersInfoResponse
import io.mverse.kslack.api.methods.response.reminders.RemindersListResponse
import io.mverse.kslack.api.methods.response.rtm.RTMConnectResponse
import io.mverse.kslack.api.methods.response.rtm.RTMStartResponse
import io.mverse.kslack.api.methods.response.search.SearchAllResponse
import io.mverse.kslack.api.methods.response.search.SearchFilesResponse
import io.mverse.kslack.api.methods.response.search.SearchMessagesResponse
import io.mverse.kslack.api.methods.response.stars.StarsAddResponse
import io.mverse.kslack.api.methods.response.stars.StarsListResponse
import io.mverse.kslack.api.methods.response.stars.StarsRemoveResponse
import io.mverse.kslack.api.methods.response.team.TeamAccessLogsResponse
import io.mverse.kslack.api.methods.response.team.TeamBillableInfoResponse
import io.mverse.kslack.api.methods.response.team.TeamInfoResponse
import io.mverse.kslack.api.methods.response.team.TeamIntegrationLogsResponse
import io.mverse.kslack.api.methods.response.team.profile.TeamProfileGetResponse
import io.mverse.kslack.api.methods.response.usergroups.UsergroupsCreateResponse
import io.mverse.kslack.api.methods.response.usergroups.UsergroupsDisableResponse
import io.mverse.kslack.api.methods.response.usergroups.UsergroupsEnableResponse
import io.mverse.kslack.api.methods.response.usergroups.UsergroupsListResponse
import io.mverse.kslack.api.methods.response.usergroups.UsergroupsUpdateResponse
import io.mverse.kslack.api.methods.response.usergroups.users.UsergroupUsersListResponse
import io.mverse.kslack.api.methods.response.usergroups.users.UsergroupUsersUpdateResponse
import io.mverse.kslack.api.methods.response.users.UsersConversationsResponse
import io.mverse.kslack.api.methods.response.users.UsersDeletePhotoResponse
import io.mverse.kslack.api.methods.response.users.UsersGetPresenceResponse
import io.mverse.kslack.api.methods.response.users.UsersIdentityResponse
import io.mverse.kslack.api.methods.response.users.UsersInfoResponse
import io.mverse.kslack.api.methods.response.users.UsersListResponse
import io.mverse.kslack.api.methods.response.users.UsersSetActiveResponse
import io.mverse.kslack.api.methods.response.users.UsersSetPhotoResponse
import io.mverse.kslack.api.methods.response.users.UsersSetPresenceResponse
import io.mverse.kslack.api.methods.response.users.profile.UsersProfileGetResponse
import io.mverse.kslack.api.methods.response.users.profile.UsersProfileSetResponse
import io.mverse.kslack.api.methods.rtm
import io.mverse.kslack.api.methods.search
import io.mverse.kslack.api.methods.stars
import io.mverse.kslack.api.methods.team
import io.mverse.kslack.api.methods.usergroups
import io.mverse.kslack.api.methods.users
import io.mverse.kslack.common.json.GsonFactory
import io.mverse.kslack.common.json.configureForSlack
import io.mverse.kslack.shortcut.model.ApiToken
import kotlinx.io.core.copyTo
import kotlinx.io.streams.asInput
import java.io.File
import java.util.*

data class BaseMethodsClient(private val httpClient: HttpClient,
                             private val gsonBuilder: GsonBuilder.() -> Unit = { configureForSlack() },
                             val defaultToken: ApiToken? = null) : MethodsClient {

  override var endpointUrlPrefix = "https://slack.com/api/"
  val gson = GsonBuilder().apply(gsonBuilder).create()

  // ----------------------------------------------------------------------------------
  // public methods
  // ----------------------------------------------------------------------------------

  override suspend fun apiTest(req: ApiTestRequest): ApiTestResponse {
    val form = HttpRequestBuilder().apply {
      body = formParams {
        append("foo", req.foo)
        append("error", req.error)
      }
    }
    return doPostForm(form, api.test)
  }

  private val SlackApiRequest.tokenOrDefault: String
    get() {
      return this.token ?: defaultToken
      ?: throw IllegalStateException("No api token could be located")
    }

  override suspend fun appsPermissionsInfo(req: AppsPermissionsInfoRequest): AppsPermissionsInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

      }
    }
    return doPostFormWithToken(builder, apps.permissions.info, req.tokenOrDefault)
  }

  override suspend fun appsPermissionsRequest(req: AppsPermissionsRequestRequest): AppsPermissionsRequestResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("trigger.id", req.triggerId)
        if (req.scopes != null) {
          append("scopes", req.scopes.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, apps.permissions.request, req.tokenOrDefault)
  }

  override suspend fun authRevoke(req: AuthRevokeRequest): AuthRevokeResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("test", req.isTest)
      }
    }
    return doPostFormWithToken(builder, auth.revoke, req.tokenOrDefault)
  }

  override suspend fun authTest(req: AuthTestRequest): AuthTestResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

      }
    }
    return doPostFormWithToken(builder, auth.test, req.tokenOrDefault)
  }

  override suspend fun botsInfo(req: BotsInfoRequest): BotsInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("bot", req.bot)
      }
    }
    return doPostFormWithToken(builder, bots.info, req.tokenOrDefault)
  }

  override suspend fun channelsArchive(req: ChannelsArchiveRequest): ChannelsArchiveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, channels.archive, req.tokenOrDefault)
  }

  override suspend fun channelsCreate(req: ChannelsCreateRequest): ChannelsCreateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("name", req.name)
        append("validate", req.isValidate)
      }
    }
    return doPostFormWithToken(builder, channels.create, req.tokenOrDefault)
  }

  override suspend fun channelsHistory(req: ChannelsHistoryRequest): ChannelsHistoryResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("latest", req.latest)
        append("oldest", req.oldest)
        append("inclusive", req.isInclusive)
        append("count", req.count)
        append("unreads", req.isUnreads)
      }
    }
    return doPostFormWithToken(builder, channels.history, req.tokenOrDefault)
  }

  override suspend fun channelsReplies(req: ChannelsRepliesRequest): ChannelsRepliesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("thread.ts", req.threadTs)
      }
    }
    return doPostFormWithToken(builder, channels.replies, req.tokenOrDefault)
  }

  override suspend fun channelsInfo(req: ChannelsInfoRequest): ChannelsInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("include.locale", req.isIncludeLocale)
      }
    }
    return doPostFormWithToken(builder, channels.info, req.tokenOrDefault)
  }

  override suspend fun channelsList(req: ChannelsListRequest): ChannelsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("limit", req.limit)
        append("cursor", req.cursor)
        append("exclude.members", req.isExcludeMembers)
        append("exclude.archived", req.isExcludeArchived)
      }
    }
    return doPostFormWithToken(builder, channels.list, req.tokenOrDefault)
  }

  override suspend fun channelsInvite(req: ChannelsInviteRequest): ChannelsInviteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, channels.invite, req.tokenOrDefault)
  }

  override suspend fun channelsJoin(req: ChannelsJoinRequest): ChannelsJoinResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("name", req.name)
        append("validate", req.isValidate)
      }
    }
    return doPostFormWithToken(builder, channels.join, req.tokenOrDefault)
  }

  override suspend fun channelsKick(req: ChannelsKickRequest): ChannelsKickResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, channels.kick, req.tokenOrDefault)
  }

  override suspend fun channelsLeave(req: ChannelsLeaveRequest): ChannelsLeaveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, channels.leave, req.tokenOrDefault)
  }

  override suspend fun channelsMark(req: ChannelsMarkRequest): ChannelsMarkResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("ts", req.ts)
      }
    }
    return doPostFormWithToken(builder, channels.mark, req.tokenOrDefault)
  }

  override suspend fun channelsRename(req: ChannelsRenameRequest): ChannelsRenameResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("name", req.name)
        append("validate", req.isValidate)
      }
    }
    return doPostFormWithToken(builder, channels.rename, req.tokenOrDefault)
  }

  override suspend fun channelsSetPurpose(req: ChannelsSetPurposeRequest): ChannelsSetPurposeResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("purpose", req.purpose)
      }
    }
    return doPostFormWithToken(builder, channels.setPurpose, req.tokenOrDefault)
  }

  override suspend fun channelsSetTopic(req: ChannelsSetTopicRequest): ChannelsSetTopicResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("topic", req.topic)
      }
    }
    return doPostFormWithToken(builder, channels.setTopic, req.tokenOrDefault)
  }

  override suspend fun channelsUnarchive(req: ChannelsUnarchiveRequest): ChannelsUnarchiveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, channels.unarchive, req.tokenOrDefault)
  }

  override suspend fun chatGetPermalink(req: ChatGetPermalinkRequest): ChatGetPermalinkResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("message.ts", req.messageTs)
      }
    }
    return doPostFormWithToken(builder, chat.getPermalink, req.tokenOrDefault)
  }

  override suspend fun chatDelete(req: ChatDeleteRequest): ChatDeleteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("ts", req.ts)
      }
    }
    return doPostFormWithToken(builder, chat.delete, req.tokenOrDefault)
  }

  override suspend fun chatMeMessage(req: ChatMeMessageRequest): ChatMeMessageResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("text", req.text)
      }
    }
    return doPostFormWithToken(builder, chat.meMessage, req.tokenOrDefault)
  }

  override suspend fun chatPostEphemeral(req: ChatPostEphemeralRequest): ChatPostEphemeralResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("text", req.text)
        append("user", req.user)
        append("as.user", req.isAsUser)
        appendJson("attachments", req.attachments)
        append("link.names", req.isLinkNames)
        append("parse", req.parse)
      }
    }
    return doPostFormWithToken(builder, chat.postEphemeral, req.tokenOrDefault)
  }

  override suspend fun chatPostMessage(req: ChatPostMessageRequest): ChatPostMessageResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("thread.ts", req.threadTs)
        append("text", req.text)
        append("parse", req.parse)
        append("link.names", req.isLinkNames)
        append("mrkdwn", req.isMrkdwn)
        appendJson("attachments", req.attachments)
        append("unfurl.links", req.isUnfurlLinks)
        append("unfurl.media", req.isUnfurlMedia)
        append("username", req.username)
        append("as.user", req.asUser)
        append("icon.url", req.iconUrl)
        append("icon.emoji", req.iconEmoji)
        append("thread.ts", req.threadTs)
        append("reply.broadcast", req.isReplyBroadcast)
      }
    }
    return doPostFormWithToken(builder, chat.postMessage, req.tokenOrDefault)
  }

  override suspend fun chatUpdate(req: ChatUpdateRequest): ChatUpdateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("ts", req.ts)
        append("channel", req.channel)
        append("text", req.text)
        append("parse", req.parse)
        appendJson("attachments", req.attachments)
        append("link.names", req.isLinkNames)
        append("as.user", req.isAsUser)
      }
    }
    return doPostFormWithToken(builder, chat.update, req.tokenOrDefault)
  }

  override suspend fun chatUnfurl(req: ChatUnfurlRequest): ChatUnfurlResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("ts", req.ts)
        append("channel", req.channel)
        append("unfurls", req.unfurls)
        append("user.auth_required", req.isUserAuthRequired)
        append("user.auth_message", req.userAuthMessage)
        append("user.auth_url", req.userAuthUrl)
      }
    }
    return doPostFormWithToken(builder, chat.unfurl, req.tokenOrDefault)
  }

  override suspend fun conversationsArchive(req: ConversationsArchiveRequest): ConversationsArchiveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, conversations.archive, req.tokenOrDefault)
  }

  override suspend fun conversationsClose(req: ConversationsCloseRequest): ConversationsCloseResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, conversations.close, req.tokenOrDefault)
  }

  override suspend fun conversationsCreate(req: ConversationsCreateRequest): ConversationsCreateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("name", req.name)
        append("is.private", req.isPrivate)
      }
    }
    return doPostFormWithToken(builder, conversations.create, req.tokenOrDefault)
  }

  override suspend fun conversationsHistory(req: ConversationsHistoryRequest): ConversationsHistoryResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("cursor", req.cursor)
        append("latest", req.latest)
        append("limit", req.limit)
        append("oldest", req.oldest)
        append("inclusive", req.isInclusive)
      }
    }
    return doPostFormWithToken(builder, conversations.history, req.tokenOrDefault)
  }

  override suspend fun conversationsInfo(req: ConversationsInfoRequest): ConversationsInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("include.locale", req.isIncludeLocale)
      }
    }
    return doPostFormWithToken(builder, conversations.info, req.tokenOrDefault)
  }

  override suspend fun conversationsInvite(req: ConversationsInviteRequest): ConversationsInviteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        if (req.users != null) {
          append("users", req.users.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, conversations.invite, req.tokenOrDefault)
  }

  override suspend fun conversationsJoin(req: ConversationsJoinRequest): ConversationsJoinResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, conversations.join, req.tokenOrDefault)
  }

  override suspend fun conversationsKick(req: ConversationsKickRequest): ConversationsKickResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, conversations.kick, req.tokenOrDefault)
  }

  override suspend fun conversationsLeave(req: ConversationsLeaveRequest): ConversationsLeaveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, conversations.leave, req.tokenOrDefault)
  }

  override suspend fun conversationsList(req: ConversationsListRequest): ConversationsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("cursor", req.cursor)
        append("exclude.archived", req.isExcludeArchived)
        append("limit", req.limit)
        append("types", req.types?.joinToString(",") { it.value })
      }
    }
    return doPostFormWithToken(builder, conversations.list, req.tokenOrDefault)
  }

  override suspend fun conversationsMembers(req: ConversationsMembersRequest): ConversationsMembersResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("cursor", req.cursor)
        append("limit", req.limit)
      }
    }
    return doPostFormWithToken(builder, conversations.members, req.tokenOrDefault)
  }

  override suspend fun conversationsOpen(req: ConversationsOpenRequest): ConversationsOpenResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("return.im", req.isReturnIm)
        if (req.users != null) {
          append("users", req.users.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, conversations.open, req.tokenOrDefault)
  }

  override suspend fun conversationsRename(req: ConversationsRenameRequest): ConversationsRenameResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("name", req.name)
      }
    }
    return doPostFormWithToken(builder, conversations.rename, req.tokenOrDefault)
  }

  override suspend fun conversationsReplies(req: ConversationsRepliesRequest): ConversationsRepliesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("ts", req.ts)
        append("cursor", req.cursor)
        append("limit", req.limit)
      }
    }
    return doPostFormWithToken(builder, conversations.replies, req.tokenOrDefault)
  }

  override suspend fun conversationsSetPurpose(req: ConversationsSetPurposeRequest): ConversationsSetPurposeResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("purpose", req.purpose)
      }
    }
    return doPostFormWithToken(builder, conversations.setPurpose, req.tokenOrDefault)
  }

  override suspend fun conversationsSetTopic(req: ConversationsSetTopicRequest): ConversationsSetTopicResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("topic", req.topic)
      }
    }
    return doPostFormWithToken(builder, conversations.setTopic, req.tokenOrDefault)
  }

  override suspend fun conversationsUnarchive(req: ConversationsUnarchiveRequest): ConversationsUnarchiveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, conversations.unarchive, req.tokenOrDefault)
  }

  override suspend fun dialogOpen(req: DialogOpenRequest): DialogOpenResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("trigger.id", req.triggerId)
        appendJson("dialog", req.dialog)
      }
    }
    return doPostFormWithToken(builder, dialog.open, req.tokenOrDefault)
  }

  override suspend fun dndEndDnd(req: DndEndDndRequest): DndEndDndResponse {
    val builder = HttpRequestBuilder()
    return doPostFormWithToken(builder, dnd.endDnd, req.tokenOrDefault)
  }

  override suspend fun dndEndSnooze(req: DndEndSnoozeRequest): DndEndSnoozeResponse {
    val builder = HttpRequestBuilder()
    return doPostFormWithToken(builder, dnd.endSnooze, req.tokenOrDefault)
  }

  override suspend fun dndInfo(req: DndInfoRequest): DndInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, dnd.info, req.tokenOrDefault)
  }

  override suspend fun dndSetSnooze(req: DndSetSnoozeRequest): DndSetSnoozeResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("num.minutes", req.numMinutes)
      }
    }
    return doPostFormWithToken(builder, dnd.setSnooze, req.tokenOrDefault)
  }

  override suspend fun dndTeamInfo(req: DndTeamInfoRequest): DndTeamInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        if (req.users != null) {
          append("user", req.users.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, dnd.teamInfo, req.tokenOrDefault)
  }

  override suspend fun emojiList(req: EmojiListRequest): EmojiListResponse {
    val builder = HttpRequestBuilder()
    return doPostFormWithToken(builder, emoji.list, req.tokenOrDefault)
  }

  override suspend fun filesDelete(req: FilesDeleteRequest): FilesDeleteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("file", req.file)
      }
    }
    return doPostFormWithToken(builder, files.delete, req.tokenOrDefault)
  }

  override suspend fun filesInfo(req: FilesInfoRequest): FilesInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("file", req.file)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, files.info, req.tokenOrDefault)
  }

  override suspend fun filesList(req: FilesListRequest): FilesListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("user", req.user)
        append("channel", req.channel)
        append("ts.from", req.tsFrom)
        append("ts.to", req.tsTo)
        if (req.types != null) {
          append("types", req.types.joinToString(","))
        }
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, files.list, req.tokenOrDefault)
  }

  override suspend fun filesRevokePublicURL(req: FilesRevokePublicURLRequest): FilesRevokePublicURLResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("file", req.file)
      }
    }
    return doPostFormWithToken(builder, files.revokePublicUrl, req.tokenOrDefault)
  }

  override suspend fun filesSharedPublicURL(req: FilesSharedPublicURLRequest): FilesSharedPublicURLResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("file", req.file)
      }
    }
    return doPostFormWithToken(builder, files.sharedPublicUrl, req.tokenOrDefault)
  }

  override suspend fun filesUpload(req: FilesUploadRequest): FilesUploadResponse {
    if (req.file != null) {
      val builder = HttpRequestBuilder().apply {
        body = formMultipart {
          append("file", req.filename, ContentType.Any, req.file)
          append("filetype", req.filetype)
          append("filename", req.filename)
          append("title", req.title)
          append("initial.comment", req.initialComment)
          if (req.channels != null) {
            append("channels", req.channels.joinToString(","))
          }
        }
      }

      return doPostMultipart(builder, files.upload, req.tokenOrDefault)
    } else {
      val builder = HttpRequestBuilder().apply {
        body = formParams {
          append("content", req.content)
          append("filetype", req.filetype)
          append("filename", req.filename)
          append("title", req.title)
          append("initial.comment", req.initialComment)
          if (req.channels != null) {
            append("channels", req.channels.joinToString(","))
          }
        }
      }
      return doPostFormWithToken(builder, files.upload, req.tokenOrDefault)
    }
  }

  override suspend fun filesCommentsAdd(req: FilesCommentsAddRequest): FilesCommentsAddResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("file", req.file)
        append("comment", req.comment)
      }
    }
    return doPostFormWithToken(builder, files.comments.add, req.tokenOrDefault)
  }

  override suspend fun filesCommentsDelete(req: FilesCommentsDeleteRequest): FilesCommentsDeleteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("file", req.file)
        append("id", req.id)
      }
    }
    return doPostFormWithToken(builder, files.comments.delete, req.tokenOrDefault)
  }

  override suspend fun filesCommentEdit(req: FilesCommentsEditRequest): FilesCommentsEditResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("file", req.file)
        append("comment", req.comment)
        append("id", req.id)
      }
    }
    return doPostFormWithToken(builder, files.comments.edit, req.tokenOrDefault)
  }

  override suspend fun groupsArchive(req: GroupsArchiveRequest): GroupsArchiveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, groups.archive, req.tokenOrDefault)
  }

  override suspend fun groupsClose(req: GroupsCloseRequest): GroupsCloseResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, groups.close, req.tokenOrDefault)
  }

  override suspend fun groupsCreateChild(req: GroupsCreateChildRequest): GroupsCreateChildResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, groups.createChild, req.tokenOrDefault)
  }

  override suspend fun groupsCreate(req: GroupsCreateRequest): GroupsCreateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("name", req.name)
        append("validate", req.isValidate)
      }
    }
    return doPostFormWithToken(builder, groups.create, req.tokenOrDefault)
  }

  override suspend fun groupsHistory(req: GroupsHistoryRequest): GroupsHistoryResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("latest", req.latest)
        append("oldest", req.oldest)
        append("inclusive", req.isInclusive)
        append("count", req.count)
        append("unreads", req.isUnreads)
      }
    }
    return doPostFormWithToken(builder, groups.history, req.tokenOrDefault)
  }

  override suspend fun groupsReplies(req: GroupsRepliesRequest): GroupsRepliesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("thread.ts", req.threadTs)
      }
    }
    return doPostFormWithToken(builder, groups.replies, req.tokenOrDefault)
  }

  override suspend fun groupsInfo(req: GroupsInfoRequest): GroupsInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("include.locale", req.isIncludeLocale)
      }
    }
    return doPostFormWithToken(builder, groups.info, req.tokenOrDefault)
  }

  override suspend fun groupsInvite(req: GroupsInviteRequest): GroupsInviteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, groups.invite, req.tokenOrDefault)
  }

  override suspend fun groupsKick(req: GroupsKickRequest): GroupsKickResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, groups.kick, req.tokenOrDefault)
  }

  override suspend fun groupsLeave(req: GroupsLeaveRequest): GroupsLeaveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, groups.leave, req.tokenOrDefault)
  }

  override suspend fun groupsList(req: GroupsListRequest): GroupsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("exclude.archived", req.isExcludeArchived)
        append("exclude.members", req.isExcludeMembers)
      }
    }
    return doPostFormWithToken(builder, groups.list, req.tokenOrDefault)
  }

  override suspend fun groupsMark(req: GroupsMarkRequest): GroupsMarkResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("ts", req.ts)
      }
    }
    return doPostFormWithToken(builder, groups.mark, req.tokenOrDefault)
  }

  override suspend fun groupsOpen(req: GroupsOpenRequest): GroupsOpenResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, groups.open, req.tokenOrDefault)
  }

  override suspend fun groupsRename(req: GroupsRenameRequest): GroupsRenameResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("name", req.name)
      }
    }
    return doPostFormWithToken(builder, groups.rename, req.tokenOrDefault)
  }

  override suspend fun groupsSetPurpose(req: GroupsSetPurposeRequest): GroupsSetPurposeResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("purpose", req.purpose)
      }
    }
    return doPostFormWithToken(builder, groups.setPurpose, req.tokenOrDefault)
  }

  override suspend fun groupsSetTopic(req: GroupsSetTopicRequest): GroupsSetTopicResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("topic", req.topic)
      }
    }
    return doPostFormWithToken(builder, groups.setTopic, req.tokenOrDefault)
  }

  override suspend fun groupsUnarchive(req: GroupsUnarchiveRequest): GroupsUnarchiveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, groups.unarchive, req.tokenOrDefault)
  }

  override suspend fun imClose(req: ImCloseRequest): ImCloseResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, im.close, req.tokenOrDefault)
  }

  override suspend fun imHistory(req: ImHistoryRequest): ImHistoryResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("latest", req.latest)
        append("oldest", req.oldest)
        append("inclusive", req.isInclusive)
        append("count", req.count)
        append("unreads", req.isUnreads)
      }
    }
    return doPostFormWithToken(builder, im.history, req.tokenOrDefault)
  }

  override suspend fun imList(req: ImListRequest): ImListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("cursor", req.cursor)
        append("limit", req.limit)
      }
    }
    return doPostFormWithToken(builder, im.list, req.tokenOrDefault)
  }

  override suspend fun imMark(req: ImMarkRequest): ImMarkResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("ts", req.ts)
      }
    }
    return doPostFormWithToken(builder, im.mark, req.tokenOrDefault)
  }

  override suspend fun imOpen(req: ImOpenRequest): ImOpenResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("user", req.user)
        append("return.im", req.isReturnIm)
        append("include.locale", req.isIncludeLocale)
      }
    }
    return doPostFormWithToken(builder, im.open, req.tokenOrDefault)
  }

  override suspend fun imReplies(req: ImRepliesRequest): ImRepliesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("thread.ts", req.threadTs)
      }
    }
    return doPostFormWithToken(builder, im.replies, req.tokenOrDefault)
  }

  override suspend fun migrationExchange(req: MigrationExchangeRequest): MigrationExchangeResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("to.old", req.isToOld)
        if (req.users != null) {
          append("users", req.users.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, migration.exchange, req.tokenOrDefault)
  }

  override suspend fun mpimClose(req: MpimCloseRequest): MpimCloseResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, mpim.close, req.tokenOrDefault)
  }

  override suspend fun mpimHistory(req: MpimHistoryRequest): MpimHistoryResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("latest", req.latest)
        append("oldest", req.oldest)
        append("inclusive", req.isInclusive)
        append("count", req.count)
        append("unreads", req.isUnreads)
      }
    }
    return doPostFormWithToken(builder, mpim.history, req.tokenOrDefault)
  }

  override suspend fun mpimList(req: MpimListRequest): MpimListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

      }
    }
    return doPostFormWithToken(builder, mpim.list, req.tokenOrDefault)
  }

  override suspend fun mpimReplies(req: MpimRepliesRequest): MpimRepliesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("thread.ts", req.threadTs)
      }
    }
    return doPostFormWithToken(builder, mpim.list, req.tokenOrDefault)
  }

  override suspend fun mpimMark(req: MpimMarkRequest): MpimMarkResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("ts", req.ts)
      }
    }
    return doPostFormWithToken(builder, mpim.mark, req.tokenOrDefault)
  }

  override suspend fun mpimOpen(req: MpimOpenRequest): MpimOpenResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        if (req.users != null) {
          append("users", req.users.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, mpim.open, req.tokenOrDefault)
  }

  override suspend fun oauthAccess(req: OAuthAccessRequest): OAuthAccessResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("client.id", req.clientId)
        append("client.secret", req.clientSecret)
        append("code", req.code)
        append("redirect.uri", req.redirectUri)
        append("single.channel", req.isSingleChannel)
      }
    }
    return doPostForm(builder, oauth.access)
  }

  override suspend fun oauthToken(req: OAuthTokenRequest): OAuthTokenResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("client.id", req.clientId)
        append("client.secret", req.clientSecret)
        append("code", req.code)
        append("redirect.uri", req.redirectUri)
        append("single.channel", req.isSingleChannel)
      }
    }
    return doPostForm(builder, oauth.token)
  }

  override suspend fun pinsAdd(req: PinsAddRequest): PinsAddResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("channel", req.channel)
        append("file", req.file)
        append("file.comment", req.fileComment)
        append("timestamp", req.timestamp)
      }
    }
    return doPostFormWithToken(builder, pins.add, req.tokenOrDefault)
  }

  override suspend fun pinsList(req: PinsListRequest): PinsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
      }
    }
    return doPostFormWithToken(builder, pins.list, req.tokenOrDefault)
  }

  override suspend fun pinsRemove(req: PinsRemoveRequest): PinsRemoveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("file", req.file)
        append("file.comment", req.fileComment)
        append("timestamp", req.timestamp)
      }
    }
    return doPostFormWithToken(builder, pins.remove, req.tokenOrDefault)
  }

  override suspend fun reactionsAdd(req: ReactionsAddRequest): ReactionsAddResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("name", req.name)
        append("file", req.file)
        append("file.comment", req.fileComment)
        append("channel", req.channel)
        append("timestamp", req.timestamp)
      }
    }
    return doPostFormWithToken(builder, reactions.add, req.tokenOrDefault)
  }

  override suspend fun reactionsGet(req: ReactionsGetRequest): ReactionsGetResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("file", req.file)
        append("file.comment", req.fileComment)
        append("channel", req.channel)
        append("timestamp", req.timestamp)
        append("full", req.isFull)
      }
    }
    return doPostFormWithToken(builder, reactions.get, req.tokenOrDefault)
  }

  override suspend fun reactionsList(req: ReactionsListRequest): ReactionsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("user", req.user)
        append("full", req.isFull)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, reactions.list, req.tokenOrDefault)
  }

  override suspend fun reactionsRemove(req: ReactionsRemoveRequest): ReactionsRemoveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("name", req.name)
        append("file", req.file)
        append("file.comment", req.fileComment)
        append("channel", req.channel)
        append("timestamp", req.timestamp)
      }
    }
    return doPostFormWithToken(builder, reactions.remove, req.tokenOrDefault)
  }

  override suspend fun remindersAdd(req: RemindersAddRequest): RemindersAddResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("text", req.text)
        append("time", req.time)
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, reminders.add, req.tokenOrDefault)
  }

  override suspend fun remindersComplete(req: RemindersCompleteRequest): RemindersCompleteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("reminder", req.reminder)
      }
    }
    return doPostFormWithToken(builder, reminders.complete, req.tokenOrDefault)
  }

  override suspend fun remindersDelete(req: RemindersDeleteRequest): RemindersDeleteResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("reminder", req.reminder)
      }
    }
    return doPostFormWithToken(builder, reminders.delete, req.tokenOrDefault)
  }

  override suspend fun remindersInfo(req: RemindersInfoRequest): RemindersInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("reminder", req.reminder)
      }
    }
    return doPostFormWithToken(builder, reminders.info, req.tokenOrDefault)
  }

  override suspend fun remindersList(req: RemindersListRequest): RemindersListResponse {
    val builder = HttpRequestBuilder()
    return doPostFormWithToken(builder, reminders.list, req.tokenOrDefault)
  }

  override suspend fun rtmConnect(req: RTMConnectRequest): RTMConnectResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("batch.presence_aware", req.isBatchPresenceAware)
        append("presence.sub", req.isPresenceSub)
      }
    }
    return doPostFormWithToken(builder, rtm.connect, req.tokenOrDefault)
  }

  override suspend fun rtmStart(req: RTMStartRequest): RTMStartResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("include.locale", req.isIncludeLocale)
        append("batch.presence_aware", req.isBatchPresenceAware)
        append("no.latest", req.isNoLatest)
        append("no.unreads", req.isNoUnreads)
        append("presence.sub", req.isPresenceSub)
        append("simple.latest", req.isSimpleLatest)
        append("mpim.aware", req.isMpimAware)
      }
    }
    return doPostFormWithToken(builder, rtm.start, req.tokenOrDefault)
  }

  override suspend fun searchAll(req: SearchAllRequest): SearchAllResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("query", req.query)
        append("sort", req.sort)
        append("sort.dir", req.sortDir)
        append("highlight", req.isHighlight)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, search.all, req.tokenOrDefault)
  }

  override suspend fun searchMessages(req: SearchMessagesRequest): SearchMessagesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("query", req.query)
        append("sort", req.sort)
        append("sort.dir", req.sortDir)
        append("highlight", req.isHighlight)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, search.messages, req.tokenOrDefault)
  }

  override suspend fun searchFiles(req: SearchFilesRequest): SearchFilesResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("query", req.query)
        append("sort", req.sort)
        append("sort.dir", req.sortDir)
        append("highlight", req.isHighlight)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, search.files, req.tokenOrDefault)
  }

  override suspend fun starsAdd(req: StarsAddRequest): StarsAddResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("file", req.file)
        append("file.comment", req.fileComment)
        append("timestamp", req.timestamp)
      }
    }
    return doPostFormWithToken(builder, stars.add, req.tokenOrDefault)
  }

  override suspend fun starsList(req: StarsListRequest): StarsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, stars.list, req.tokenOrDefault)
  }

  override suspend fun starsRemove(req: StarsRemoveRequest): StarsRemoveResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("channel", req.channel)
        append("file", req.file)
        append("file.comment", req.fileComment)
        append("timestamp", req.timestamp)
      }
    }
    return doPostFormWithToken(builder, stars.remove, req.tokenOrDefault)
  }

  override suspend fun teamAccessLogs(req: TeamAccessLogsRequest): TeamAccessLogsResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("before", req.before)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, team.accessLogs, req.tokenOrDefault)
  }

  override suspend fun teamBillableInfo(req: TeamBillableInfoRequest): TeamBillableInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, team.billableInfo, req.tokenOrDefault)
  }

  override suspend fun teamInfo(req: TeamInfoRequest): TeamInfoResponse {
    val builder = HttpRequestBuilder()
    return doPostFormWithToken(builder, team.info, req.tokenOrDefault)
  }

  override suspend fun teamIntegrationLogs(req: TeamIntegrationLogsRequest): TeamIntegrationLogsResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("service.id", req.serviceId)
        append("user", req.user)
        append("change.type", req.changeType)
        append("count", req.count)
        append("page", req.page)
      }
    }
    return doPostFormWithToken(builder, team.integrationLogs, req.tokenOrDefault)
  }

  override suspend fun teamProfileGet(req: TeamProfileGetRequest): TeamProfileGetResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("visibility", req.visibility)
      }
    }
    return doPostFormWithToken(builder, team.profile.get, req.tokenOrDefault)
  }

  override suspend fun usergroupsCreate(req: UsergroupsCreateRequest): UsergroupsCreateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("name", req.name)
        append("handle", req.handle)
        append("description", req.description)
        if (req.channels != null) {
          append("channels", req.channels.joinToString(","))
        }
        append("include.count", req.isIncludeCount)
      }
    }
    return doPostFormWithToken(builder, usergroups.create, req.tokenOrDefault)
  }

  override suspend fun usergroupsDisable(req: UsergroupsDisableRequest): UsergroupsDisableResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("usergroup", req.usergroup)
        append("include.count", req.isIncludeCount)
      }
    }
    return doPostFormWithToken(builder, usergroups.disable, req.tokenOrDefault)
  }

  override suspend fun usergroupsEnable(req: UsergroupsEnableRequest): UsergroupsEnableResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("usergroup", req.usergroup)
        append("include.count", req.isIncludeCount)
      }
    }
    return doPostFormWithToken(builder, usergroups.enable, req.tokenOrDefault)
  }

  override suspend fun usergroupsList(req: UsergroupsListRequest): UsergroupsListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("include.disabled", req.isIncludeDisabled)
        append("include.count", req.isIncludeCount)
        append("include.users", req.isIncludeUsers)
      }
    }
    return doPostFormWithToken(builder, usergroups.list, req.tokenOrDefault)
  }

  override suspend fun usergroupsUpdate(req: UsergroupsUpdateRequest): UsergroupsUpdateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("usergroup", req.usergroup)
        append("name", req.name)
        append("handle", req.handle)
        append("description", req.description)
        if (req.channels != null) {
          append("channels", req.channels.joinToString(","))
        }
        append("include.count", req.isIncludeCount)
      }
    }
    return doPostFormWithToken(builder, usergroups.update, req.tokenOrDefault)
  }

  override suspend fun usergroupUsersList(req: UsergroupUsersListRequest): UsergroupUsersListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("usergroup", req.usergroup)
        append("include.disabled", req.isIncludeDisabled)
      }
    }
    return doPostFormWithToken(builder, usergroups.users.list, req.tokenOrDefault)
  }

  override suspend fun usergroupUsersUpdate(req: UsergroupUsersUpdateRequest): UsergroupUsersUpdateResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("usergroup", req.usergroup)
        if (req.users != null) {
          append("users", req.users.joinToString(","))
        }
        append("include.count", req.isIncludeCount)
      }
    }
    return doPostFormWithToken(builder, usergroups.users.update, req.tokenOrDefault)
  }

  override suspend fun usersConversations(req: UsersConversationsRequest): UsersConversationsResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("user", req.user)
        append("cursor", req.cursor)
        append("exclude.archived", req.isExcludeArchived)
        append("limit", req.limit)

        if (req.types != null) {
          val typeValues = ArrayList<String>()
          for (type in req.types) {
            typeValues.add(type.value)
          }
          append("types", typeValues.joinToString(","))
        }
      }
    }
    return doPostFormWithToken(builder, users.conversations, req.tokenOrDefault)
  }

  override suspend fun usersDeletePhoto(req: UsersDeletePhotoRequest): UsersDeletePhotoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

      }
    }
    return doPostFormWithToken(builder, users.deletePhoto, req.tokenOrDefault)
  }

  override suspend fun usersGetPresence(req: UsersGetPresenceRequest): UsersGetPresenceResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("user", req.user)
      }
    }
    return doPostFormWithToken(builder, users.getPresence, req.tokenOrDefault)
  }

  override suspend fun usersIdentity(req: UsersIdentityRequest): UsersIdentityResponse {
    val builder = HttpRequestBuilder().apply {
    }
    return doPostFormWithToken(builder, users.identity, req.tokenOrDefault)
  }

  override suspend fun usersInfo(req: UsersInfoRequest): UsersInfoResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("user", req.user)
        append("include.locale", req.isIncludeLocale)
      }
    }
    return doPostFormWithToken(builder, users.info, req.tokenOrDefault)
  }

  override suspend fun usersList(req: UsersListRequest): UsersListResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("cursor", req.cursor)
        append("limit", req.limit)
        append("include.locale", req.isIncludeLocale)
        append("presence", req.isPresence)
      }
    }
    return doPostFormWithToken(builder, users.list, req.tokenOrDefault)
  }

  override suspend fun usersLookupByEmail(req: UsersLookupByEmailRequest): UsersLookupByEmailResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("email", req.email)
      }
    }
    return doPostFormWithToken(builder, users.lookupByEmail, req.tokenOrDefault)
  }

  override suspend fun usersSetActive(req: UsersSetActiveRequest): UsersSetActiveResponse {
    val builder = HttpRequestBuilder()
    return doPostFormWithToken(builder, users.setActive, req.tokenOrDefault)
  }

  override suspend fun usersSetPhoto(req: UsersSetPhotoRequest): UsersSetPhotoResponse {
    val form = HttpRequestBuilder().apply {
      body = formMultipart {
        append("image", "image", Image.Any, req.image)
        append("crop.x", req.cropX)
        append("crop.y", req.cropY)
        append("crop.w", req.cropW)
      }
    }

    return doPostMultipart(form, users.setPhoto, req.tokenOrDefault)
  }

  override suspend fun usersSetPresence(req: UsersSetPresenceRequest): UsersSetPresenceResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {
        append("presence", req.presence)
      }
    }
    return doPostFormWithToken(builder, users.setPresence, req.tokenOrDefault)
  }

  override suspend fun usersProfileGet(req: UsersProfileGetRequest): UsersProfileGetResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("user", req.user)
        append("include.labels", req.isIncludeLabels)
      }
    }
    return doPostFormWithToken(builder, users.profile.get, req.tokenOrDefault)
  }

  override suspend fun usersProfileSet(req: UsersProfileSetRequest): UsersProfileSetResponse {
    val builder = HttpRequestBuilder().apply {
      body = formParams {

        append("user", req.user)
        if (req.profile != null) {
          append("profile", GsonFactory.createSnakeCase().toJson(req.profile))
        } else {
          append("name", req.name)
          append("value", req.value)
        }
      }
    }
    return doPostFormWithToken(builder, users.profile.set, req.tokenOrDefault)
  }

  // ----------------------------------------------------------------------------------
  // private methods
  // ----------------------------------------------------------------------------------

  private suspend inline fun <reified T> doPostForm(requestBuilder: HttpRequestBuilder, endpoint: String): T {
    requestBuilder.url.takeFrom(endpointUrlPrefix + endpoint)
    defaultToken?.let { token ->
      requestBuilder.header("Authorization", "Bearer $token")
    }
    return httpClient.post(requestBuilder)
  }

  private suspend inline fun <reified T> doPostFormWithToken(builder: HttpRequestBuilder, endpoint: String, token: String? = defaultToken): T {
    builder.url.takeFrom(endpointUrlPrefix + endpoint)
    token?.let { token ->
      builder.header("Authorization", "Bearer $token")
    }
    return httpClient.post(builder)
  }

  private suspend inline fun <reified T> doPostMultipart(builder: HttpRequestBuilder, endpoint: String, token: String? = defaultToken): T {
    builder.url.takeFrom(endpointUrlPrefix + endpoint)
    token?.let { token ->
      builder.header("Authorization", "Bearer $token")
    }
    return httpClient.post(builder)
  }

  fun formParams(block: ParametersBuilder.() -> Unit): FormDataContent = FormDataContent(ParametersBuilder().apply(block).build())
  fun formMultipart(block: FormBuilder.() -> Unit): MultiPartFormDataContent = MultiPartFormDataContent(formData {block()})

  fun <A : Any> FormBuilder.appendJson(key: String, value: A?) = value?.let { append(key, gson.toJson(value)) }
  fun <A : Any> ParametersBuilder.appendJson(key: String, value: A?) = value?.let { append(key, gson.toJson(value)) }
  fun ParametersBuilder.append(key: String, value: String?) = value?.let { append(key, it) }
  fun ParametersBuilder.append(key: String, value: Boolean?) = value?.let { append(key, if(it) "1" else "0") }
  fun ParametersBuilder.append(key: String, value: Number?) = value?.let { append(key, "$it") }
  fun <A : Any> FormBuilder.append(key: String, value: A?) = value?.let { append(key, value) }
  fun FormBuilder.append(key: String, filename: String? = null, contentType: ContentType = ContentType.Any, file: File?) =
      file?.let {
        append(key, Headers.build {
          set(HttpHeaders.ContentType, contentType.contentType)
          if (filename != null) {
            set(HttpHeaders.ContentDisposition, "filename=$filename")
          }
        }) { file.inputStream().asInput().copyTo(this) }
      }
}
