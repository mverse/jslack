package com.github.seratch.jslack.api.methods.impl

import com.github.seratch.jslack.api.methods.Methods
import com.github.seratch.jslack.api.methods.MethodsClient
import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.methods.request.api.ApiTestRequest
import com.github.seratch.jslack.api.methods.request.apps.permissions.AppsPermissionsInfoRequest
import com.github.seratch.jslack.api.methods.request.apps.permissions.AppsPermissionsRequestRequest
import com.github.seratch.jslack.api.methods.request.auth.AuthRevokeRequest
import com.github.seratch.jslack.api.methods.request.auth.AuthTestRequest
import com.github.seratch.jslack.api.methods.request.bots.BotsInfoRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsArchiveRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsCreateRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsHistoryRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsInfoRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsInviteRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsJoinRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsKickRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsLeaveRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsListRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsMarkRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsRenameRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsRepliesRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsSetPurposeRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsSetTopicRequest
import com.github.seratch.jslack.api.methods.request.channels.ChannelsUnarchiveRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatDeleteRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatGetPermalinkRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatMeMessageRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatPostEphemeralRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatUnfurlRequest
import com.github.seratch.jslack.api.methods.request.chat.ChatUpdateRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsArchiveRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsCloseRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsCreateRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsHistoryRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsInfoRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsInviteRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsJoinRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsKickRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsLeaveRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsListRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsMembersRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsOpenRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsRenameRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsRepliesRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsSetPurposeRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsSetTopicRequest
import com.github.seratch.jslack.api.methods.request.conversations.ConversationsUnarchiveRequest
import com.github.seratch.jslack.api.methods.request.dialog.DialogOpenRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndEndDndRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndEndSnoozeRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndInfoRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndSetSnoozeRequest
import com.github.seratch.jslack.api.methods.request.dnd.DndTeamInfoRequest
import com.github.seratch.jslack.api.methods.request.emoji.EmojiListRequest
import com.github.seratch.jslack.api.methods.request.files.FilesDeleteRequest
import com.github.seratch.jslack.api.methods.request.files.FilesInfoRequest
import com.github.seratch.jslack.api.methods.request.files.FilesListRequest
import com.github.seratch.jslack.api.methods.request.files.FilesRevokePublicURLRequest
import com.github.seratch.jslack.api.methods.request.files.FilesSharedPublicURLRequest
import com.github.seratch.jslack.api.methods.request.files.FilesUploadRequest
import com.github.seratch.jslack.api.methods.request.files.comments.FilesCommentsAddRequest
import com.github.seratch.jslack.api.methods.request.files.comments.FilesCommentsDeleteRequest
import com.github.seratch.jslack.api.methods.request.files.comments.FilesCommentsEditRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsArchiveRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsCloseRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsCreateChildRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsCreateRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsHistoryRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsInfoRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsInviteRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsKickRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsLeaveRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsListRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsMarkRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsOpenRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsRenameRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsRepliesRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsSetPurposeRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsSetTopicRequest
import com.github.seratch.jslack.api.methods.request.groups.GroupsUnarchiveRequest
import com.github.seratch.jslack.api.methods.request.im.ImCloseRequest
import com.github.seratch.jslack.api.methods.request.im.ImHistoryRequest
import com.github.seratch.jslack.api.methods.request.im.ImListRequest
import com.github.seratch.jslack.api.methods.request.im.ImMarkRequest
import com.github.seratch.jslack.api.methods.request.im.ImOpenRequest
import com.github.seratch.jslack.api.methods.request.im.ImRepliesRequest
import com.github.seratch.jslack.api.methods.request.migration.MigrationExchangeRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimCloseRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimHistoryRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimListRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimMarkRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimOpenRequest
import com.github.seratch.jslack.api.methods.request.mpim.MpimRepliesRequest
import com.github.seratch.jslack.api.methods.request.oauth.OAuthAccessRequest
import com.github.seratch.jslack.api.methods.request.oauth.OAuthTokenRequest
import com.github.seratch.jslack.api.methods.request.pins.PinsAddRequest
import com.github.seratch.jslack.api.methods.request.pins.PinsListRequest
import com.github.seratch.jslack.api.methods.request.pins.PinsRemoveRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsAddRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsGetRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsListRequest
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsRemoveRequest
import com.github.seratch.jslack.api.methods.request.reminders.RemindersAddRequest
import com.github.seratch.jslack.api.methods.request.reminders.RemindersCompleteRequest
import com.github.seratch.jslack.api.methods.request.reminders.RemindersDeleteRequest
import com.github.seratch.jslack.api.methods.request.reminders.RemindersInfoRequest
import com.github.seratch.jslack.api.methods.request.reminders.RemindersListRequest
import com.github.seratch.jslack.api.methods.request.rtm.RTMConnectRequest
import com.github.seratch.jslack.api.methods.request.rtm.RTMStartRequest
import com.github.seratch.jslack.api.methods.request.search.SearchAllRequest
import com.github.seratch.jslack.api.methods.request.search.SearchFilesRequest
import com.github.seratch.jslack.api.methods.request.search.SearchMessagesRequest
import com.github.seratch.jslack.api.methods.request.stars.StarsAddRequest
import com.github.seratch.jslack.api.methods.request.stars.StarsListRequest
import com.github.seratch.jslack.api.methods.request.stars.StarsRemoveRequest
import com.github.seratch.jslack.api.methods.request.team.TeamAccessLogsRequest
import com.github.seratch.jslack.api.methods.request.team.TeamBillableInfoRequest
import com.github.seratch.jslack.api.methods.request.team.TeamInfoRequest
import com.github.seratch.jslack.api.methods.request.team.TeamIntegrationLogsRequest
import com.github.seratch.jslack.api.methods.request.team.profile.TeamProfileGetRequest
import com.github.seratch.jslack.api.methods.request.usergroups.UsergroupsCreateRequest
import com.github.seratch.jslack.api.methods.request.usergroups.UsergroupsDisableRequest
import com.github.seratch.jslack.api.methods.request.usergroups.UsergroupsEnableRequest
import com.github.seratch.jslack.api.methods.request.usergroups.UsergroupsListRequest
import com.github.seratch.jslack.api.methods.request.usergroups.UsergroupsUpdateRequest
import com.github.seratch.jslack.api.methods.request.usergroups.users.UsergroupUsersListRequest
import com.github.seratch.jslack.api.methods.request.usergroups.users.UsergroupUsersUpdateRequest
import com.github.seratch.jslack.api.methods.request.users.UsersConversationsRequest
import com.github.seratch.jslack.api.methods.request.users.UsersDeletePhotoRequest
import com.github.seratch.jslack.api.methods.request.users.UsersGetPresenceRequest
import com.github.seratch.jslack.api.methods.request.users.UsersIdentityRequest
import com.github.seratch.jslack.api.methods.request.users.UsersInfoRequest
import com.github.seratch.jslack.api.methods.request.users.UsersListRequest
import com.github.seratch.jslack.api.methods.request.users.UsersLookupByEmailRequest
import com.github.seratch.jslack.api.methods.request.users.UsersSetActiveRequest
import com.github.seratch.jslack.api.methods.request.users.UsersSetPhotoRequest
import com.github.seratch.jslack.api.methods.request.users.UsersSetPresenceRequest
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileGetRequest
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileSetRequest
import com.github.seratch.jslack.api.methods.response.api.ApiTestResponse
import com.github.seratch.jslack.api.methods.response.apps.permissions.AppsPermissionsInfoResponse
import com.github.seratch.jslack.api.methods.response.apps.permissions.AppsPermissionsRequestResponse
import com.github.seratch.jslack.api.methods.response.auth.AuthRevokeResponse
import com.github.seratch.jslack.api.methods.response.auth.AuthTestResponse
import com.github.seratch.jslack.api.methods.response.bots.BotsInfoResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsArchiveResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsCreateResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsHistoryResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsInfoResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsInviteResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsJoinResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsKickResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsLeaveResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsListResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsMarkResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsRenameResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsRepliesResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsSetPurposeResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsSetTopicResponse
import com.github.seratch.jslack.api.methods.response.channels.ChannelsUnarchiveResponse
import com.github.seratch.jslack.api.methods.response.channels.UsersLookupByEmailResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatDeleteResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatGetPermalinkResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatMeMessageResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatPostEphemeralResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatUnfurlResponse
import com.github.seratch.jslack.api.methods.response.chat.ChatUpdateResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsArchiveResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsCloseResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsCreateResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsHistoryResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsInfoResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsInviteResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsJoinResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsKickResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsLeaveResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsListResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsMembersResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsOpenResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsRenameResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsRepliesResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsSetPurposeResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsSetTopicResponse
import com.github.seratch.jslack.api.methods.response.conversations.ConversationsUnarchiveResponse
import com.github.seratch.jslack.api.methods.response.dialog.DialogOpenResponse
import com.github.seratch.jslack.api.methods.response.dnd.DndEndDndResponse
import com.github.seratch.jslack.api.methods.response.dnd.DndEndSnoozeResponse
import com.github.seratch.jslack.api.methods.response.dnd.DndInfoResponse
import com.github.seratch.jslack.api.methods.response.dnd.DndSetSnoozeResponse
import com.github.seratch.jslack.api.methods.response.dnd.DndTeamInfoResponse
import com.github.seratch.jslack.api.methods.response.emoji.EmojiListResponse
import com.github.seratch.jslack.api.methods.response.files.FilesDeleteResponse
import com.github.seratch.jslack.api.methods.response.files.FilesInfoResponse
import com.github.seratch.jslack.api.methods.response.files.FilesListResponse
import com.github.seratch.jslack.api.methods.response.files.FilesRevokePublicURLResponse
import com.github.seratch.jslack.api.methods.response.files.FilesSharedPublicURLResponse
import com.github.seratch.jslack.api.methods.response.files.FilesUploadResponse
import com.github.seratch.jslack.api.methods.response.files.comments.FilesCommentsAddResponse
import com.github.seratch.jslack.api.methods.response.files.comments.FilesCommentsDeleteResponse
import com.github.seratch.jslack.api.methods.response.files.comments.FilesCommentsEditResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsArchiveResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsCloseResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsCreateChildResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsCreateResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsHistoryResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsInfoResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsInviteResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsKickResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsLeaveResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsListResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsMarkResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsOpenResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsRenameResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsRepliesResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsSetPurposeResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsSetTopicResponse
import com.github.seratch.jslack.api.methods.response.groups.GroupsUnarchiveResponse
import com.github.seratch.jslack.api.methods.response.im.ImCloseResponse
import com.github.seratch.jslack.api.methods.response.im.ImHistoryResponse
import com.github.seratch.jslack.api.methods.response.im.ImListResponse
import com.github.seratch.jslack.api.methods.response.im.ImMarkResponse
import com.github.seratch.jslack.api.methods.response.im.ImOpenResponse
import com.github.seratch.jslack.api.methods.response.im.ImRepliesResponse
import com.github.seratch.jslack.api.methods.response.migration.MigrationExchangeResponse
import com.github.seratch.jslack.api.methods.response.mpim.MpimCloseResponse
import com.github.seratch.jslack.api.methods.response.mpim.MpimHistoryResponse
import com.github.seratch.jslack.api.methods.response.mpim.MpimListResponse
import com.github.seratch.jslack.api.methods.response.mpim.MpimMarkResponse
import com.github.seratch.jslack.api.methods.response.mpim.MpimOpenResponse
import com.github.seratch.jslack.api.methods.response.mpim.MpimRepliesResponse
import com.github.seratch.jslack.api.methods.response.oauth.OAuthAccessResponse
import com.github.seratch.jslack.api.methods.response.oauth.OAuthTokenResponse
import com.github.seratch.jslack.api.methods.response.pins.PinsAddResponse
import com.github.seratch.jslack.api.methods.response.pins.PinsListResponse
import com.github.seratch.jslack.api.methods.response.pins.PinsRemoveResponse
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsAddResponse
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsGetResponse
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsListResponse
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsRemoveResponse
import com.github.seratch.jslack.api.methods.response.reminders.RemindersAddResponse
import com.github.seratch.jslack.api.methods.response.reminders.RemindersCompleteResponse
import com.github.seratch.jslack.api.methods.response.reminders.RemindersDeleteResponse
import com.github.seratch.jslack.api.methods.response.reminders.RemindersInfoResponse
import com.github.seratch.jslack.api.methods.response.reminders.RemindersListResponse
import com.github.seratch.jslack.api.methods.response.rtm.RTMConnectResponse
import com.github.seratch.jslack.api.methods.response.rtm.RTMStartResponse
import com.github.seratch.jslack.api.methods.response.search.SearchAllResponse
import com.github.seratch.jslack.api.methods.response.search.SearchFilesResponse
import com.github.seratch.jslack.api.methods.response.search.SearchMessagesResponse
import com.github.seratch.jslack.api.methods.response.stars.StarsAddResponse
import com.github.seratch.jslack.api.methods.response.stars.StarsListResponse
import com.github.seratch.jslack.api.methods.response.stars.StarsRemoveResponse
import com.github.seratch.jslack.api.methods.response.team.TeamAccessLogsResponse
import com.github.seratch.jslack.api.methods.response.team.TeamBillableInfoResponse
import com.github.seratch.jslack.api.methods.response.team.TeamInfoResponse
import com.github.seratch.jslack.api.methods.response.team.TeamIntegrationLogsResponse
import com.github.seratch.jslack.api.methods.response.team.profile.TeamProfileGetResponse
import com.github.seratch.jslack.api.methods.response.usergroups.UsergroupsCreateResponse
import com.github.seratch.jslack.api.methods.response.usergroups.UsergroupsDisableResponse
import com.github.seratch.jslack.api.methods.response.usergroups.UsergroupsEnableResponse
import com.github.seratch.jslack.api.methods.response.usergroups.UsergroupsListResponse
import com.github.seratch.jslack.api.methods.response.usergroups.UsergroupsUpdateResponse
import com.github.seratch.jslack.api.methods.response.usergroups.users.UsergroupUsersListResponse
import com.github.seratch.jslack.api.methods.response.usergroups.users.UsergroupUsersUpdateResponse
import com.github.seratch.jslack.api.methods.response.users.UsersConversationsResponse
import com.github.seratch.jslack.api.methods.response.users.UsersDeletePhotoResponse
import com.github.seratch.jslack.api.methods.response.users.UsersGetPresenceResponse
import com.github.seratch.jslack.api.methods.response.users.UsersIdentityResponse
import com.github.seratch.jslack.api.methods.response.users.UsersInfoResponse
import com.github.seratch.jslack.api.methods.response.users.UsersListResponse
import com.github.seratch.jslack.api.methods.response.users.UsersSetActiveResponse
import com.github.seratch.jslack.api.methods.response.users.UsersSetPhotoResponse
import com.github.seratch.jslack.api.methods.response.users.UsersSetPresenceResponse
import com.github.seratch.jslack.api.methods.response.users.profile.UsersProfileGetResponse
import com.github.seratch.jslack.api.methods.response.users.profile.UsersProfileSetResponse
import com.github.seratch.jslack.common.http.SlackHttpClient
import com.github.seratch.jslack.common.json.GsonFactory
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.IOException
import java.util.*
import java.util.stream.Collectors.joining

class MethodsClientImpl(private val slackHttpClient: SlackHttpClient) : MethodsClient {

  private var endpointUrlPrefix = "https://slack.com/api/"

  override fun setEndpointUrlPrefix(endpointUrlPrefix: String) {
    this.endpointUrlPrefix = endpointUrlPrefix
  }

  // ----------------------------------------------------------------------------------
  // public methods
  // ----------------------------------------------------------------------------------


  override fun apiTest(req: ApiTestRequest): ApiTestResponse {
    val form = FormBody.Builder()
    setIfNotNull("foo", req.foo, form)
    setIfNotNull("error", req.error, form)
    return doPostForm(form, Methods.API_TEST, ApiTestResponse::class.java)
  }


  override fun appsPermissionsInfo(req: AppsPermissionsInfoRequest): AppsPermissionsInfoResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.APPS_PERMISSIONS_INFO, req.token, AppsPermissionsInfoResponse::class.java)
  }


  override fun appsPermissionsRequest(req: AppsPermissionsRequestRequest): AppsPermissionsRequestResponse {
    val form = FormBody.Builder()
    setIfNotNull("trigger_id", req.triggerId, form)
    if (req.scopes != null) {
      setIfNotNull("scopes", req.scopes.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.APPS_PERMISSIONS_REQUEST, req.token, AppsPermissionsRequestResponse::class.java)
  }


  override fun authRevoke(req: AuthRevokeRequest): AuthRevokeResponse {
    val form = FormBody.Builder()
    setIfNotNull("test", req.isTest, form)
    return doPostFormWithToken(form, Methods.AUTH_REVOKE, req.token, AuthRevokeResponse::class.java)
  }


  override fun authTest(req: AuthTestRequest): AuthTestResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.AUTH_TEST, req.token, AuthTestResponse::class.java)
  }


  override fun botsInfo(req: BotsInfoRequest): BotsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("bot", req.bot, form)
    return doPostFormWithToken(form, Methods.BOTS_INFO, req.token, BotsInfoResponse::class.java)
  }


  override fun channelsArchive(req: ChannelsArchiveRequest): ChannelsArchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CHANNELS_ARCHIVE, req.token, ChannelsArchiveResponse::class.java)
  }


  override fun channelsCreate(req: ChannelsCreateRequest): ChannelsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.CHANNELS_CREATE, req.token, ChannelsCreateResponse::class.java)
  }


  override fun channelsHistory(req: ChannelsHistoryRequest): ChannelsHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.CHANNELS_HISTORY, req.token, ChannelsHistoryResponse::class.java)
  }


  override fun channelsReplies(req: ChannelsRepliesRequest): ChannelsRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.CHANNELS_REPLIES, req.token, ChannelsRepliesResponse::class.java)
  }


  override fun channelsInfo(req: ChannelsInfoRequest): ChannelsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.CHANNELS_INFO, req.token, ChannelsInfoResponse::class.java)
  }


  override fun channelsList(req: ChannelsListRequest): ChannelsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("limit", req.limit, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("exclude_members", req.isExcludeMembers, form)
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    return doPostFormWithToken(form, Methods.CHANNELS_LIST, req.token, ChannelsListResponse::class.java)
  }


  override fun channelsInvite(req: ChannelsInviteRequest): ChannelsInviteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.CHANNELS_INVITE, req.token, ChannelsInviteResponse::class.java)
  }


  override fun channelsJoin(req: ChannelsJoinRequest): ChannelsJoinResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.CHANNELS_JOIN, req.token, ChannelsJoinResponse::class.java)
  }


  override fun channelsKick(req: ChannelsKickRequest): ChannelsKickResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.CHANNELS_KICK, req.token, ChannelsKickResponse::class.java)
  }


  override fun channelsLeave(req: ChannelsLeaveRequest): ChannelsLeaveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CHANNELS_LEAVE, req.token, ChannelsLeaveResponse::class.java)
  }


  override fun channelsMark(req: ChannelsMarkRequest): ChannelsMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.CHANNELS_MARK, req.token, ChannelsMarkResponse::class.java)
  }


  override fun channelsRename(req: ChannelsRenameRequest): ChannelsRenameResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.CHANNELS_RENAME, req.token, ChannelsRenameResponse::class.java)
  }


  override fun channelsSetPurpose(req: ChannelsSetPurposeRequest): ChannelsSetPurposeResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("purpose", req.purpose, form)
    return doPostFormWithToken(form, Methods.CHANNELS_SET_PURPOSE, req.token, ChannelsSetPurposeResponse::class.java)
  }


  override fun channelsSetTopic(req: ChannelsSetTopicRequest): ChannelsSetTopicResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("topic", req.topic, form)
    return doPostFormWithToken(form, Methods.CHANNELS_SET_TOPIC, req.token, ChannelsSetTopicResponse::class.java)
  }


  override fun channelsUnarchive(req: ChannelsUnarchiveRequest): ChannelsUnarchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CHANNELS_UNARCHIVE, req.token, ChannelsUnarchiveResponse::class.java)
  }


  override fun chatGetPermalink(req: ChatGetPermalinkRequest): ChatGetPermalinkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("message_ts", req.messageTs, form)
    return doPostFormWithToken(form, Methods.CHAT_GET_PERMALINK, req.token, ChatGetPermalinkResponse::class.java)
  }


  override fun chatDelete(req: ChatDeleteRequest): ChatDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.CHAT_DELETE, req.token, ChatDeleteResponse::class.java)
  }


  override fun chatMeMessage(req: ChatMeMessageRequest): ChatMeMessageResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("text", req.text, form)
    return doPostFormWithToken(form, Methods.CHAT_ME_MESSAGE, req.token, ChatMeMessageResponse::class.java)
  }


  override fun chatPostEphemeral(req: ChatPostEphemeralRequest): ChatPostEphemeralResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("text", req.text, form)
    setIfNotNull("user", req.user, form)
    setIfNotNull("as_user", req.isAsUser, form)
    if (req.attachments != null) {
      val json = GsonFactory.createSnakeCase().toJson(req.attachments)
      form.add("attachments", json)
    }
    setIfNotNull("link_names", req.isLinkNames, form)
    setIfNotNull("parse", req.parse, form)
    return doPostFormWithToken(form, Methods.CHAT_POST_EPHEMERAL, req.token, ChatPostEphemeralResponse::class.java)
  }


  override fun chatPostMessage(req: ChatPostMessageRequest): ChatPostMessageResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    setIfNotNull("text", req.text, form)
    setIfNotNull("parse", req.parse, form)
    setIfNotNull("link_names", req.isLinkNames, form)
    setIfNotNull("mrkdwn", req.isMrkdwn, form)
    if (req.attachments != null) {
      val json = GsonFactory.createSnakeCase().toJson(req.attachments)
      form.add("attachments", json)
    }
    setIfNotNull("unfurl_links", req.isUnfurlLinks, form)
    setIfNotNull("unfurl_media", req.isUnfurlMedia, form)
    setIfNotNull("username", req.username, form)
    setIfNotNull("as_user", req.asUser, form)
    setIfNotNull("icon_url", req.iconUrl, form)
    setIfNotNull("icon_emoji", req.iconEmoji, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    setIfNotNull("reply_broadcast", req.isReplyBroadcast, form)
    return doPostFormWithToken(form, Methods.CHAT_POST_MESSAGE, req.token, ChatPostMessageResponse::class.java)
  }


  override fun chatUpdate(req: ChatUpdateRequest): ChatUpdateResponse {
    val form = FormBody.Builder()
    setIfNotNull("ts", req.ts, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("text", req.text, form)
    setIfNotNull("parse", req.parse, form)
    setIfNotNull("link_names", req.isLinkNames, form)
    if (req.attachments != null) {
      val json = GsonFactory.createSnakeCase().toJson(req.attachments)
      form.add("attachments", json)
    }
    setIfNotNull("as_user", req.isAsUser, form)
    return doPostFormWithToken(form, Methods.CHAT_UPDATE, req.token, ChatUpdateResponse::class.java)
  }


  override fun chatUnfurl(req: ChatUnfurlRequest): ChatUnfurlResponse {
    val form = FormBody.Builder()
    setIfNotNull("ts", req.ts, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("unfurls", req.unfurls, form)
    setIfNotNull("user_auth_required", req.isUserAuthRequired, form)
    setIfNotNull("user_auth_message", req.userAuthMessage, form)
    setIfNotNull("user_auth_url", req.userAuthUrl, form)
    return doPostFormWithToken(form, Methods.CHAT_UNFURL, req.token, ChatUnfurlResponse::class.java)
  }


  override fun conversationsArchive(req: ConversationsArchiveRequest): ConversationsArchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_ARCHIVE, req.token, ConversationsArchiveResponse::class.java)
  }


  override fun conversationsClose(req: ConversationsCloseRequest): ConversationsCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_CLOSE, req.token, ConversationsCloseResponse::class.java)
  }


  override fun conversationsCreate(req: ConversationsCreateRequest): ConversationsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("is_private", req.isPrivate, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_CREATE, req.token, ConversationsCreateResponse::class.java)
  }


  override fun conversationsHistory(req: ConversationsHistoryRequest): ConversationsHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("limit", req.limit, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_HISTORY, req.token, ConversationsHistoryResponse::class.java)
  }


  override fun conversationsInfo(req: ConversationsInfoRequest): ConversationsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_INFO, req.token, ConversationsInfoResponse::class.java)
  }


  override fun conversationsInvite(req: ConversationsInviteRequest): ConversationsInviteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.CONVERSATIONS_INVITE, req.token, ConversationsInviteResponse::class.java)
  }


  override fun conversationsJoin(req: ConversationsJoinRequest): ConversationsJoinResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_JOIN, req.token, ConversationsJoinResponse::class.java)
  }


  override fun conversationsKick(req: ConversationsKickRequest): ConversationsKickResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_KICK, req.token, ConversationsKickResponse::class.java)
  }


  override fun conversationsLeave(req: ConversationsLeaveRequest): ConversationsLeaveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_LEAVE, req.token, ConversationsLeaveResponse::class.java)
  }


  override fun conversationsList(req: ConversationsListRequest): ConversationsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    setIfNotNull("limit", req.limit, form)

    if (req.types != null) {
      val typeValues = ArrayList<String>()
      for (type in req.types) {
        typeValues.add(type.value())
      }
      setIfNotNull("types", typeValues.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.CONVERSATIONS_LIST, req.token, ConversationsListResponse::class.java)
  }


  override fun conversationsMembers(req: ConversationsMembersRequest): ConversationsMembersResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_MEMBERS, req.token, ConversationsMembersResponse::class.java)
  }


  override fun conversationsOpen(req: ConversationsOpenRequest): ConversationsOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("return_im", req.isReturnIm, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.CONVERSATIONS_OPEN, req.token, ConversationsOpenResponse::class.java)
  }


  override fun conversationsRename(req: ConversationsRenameRequest): ConversationsRenameResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("name", req.name, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_RENAME, req.token, ConversationsRenameResponse::class.java)
  }


  override fun conversationsReplies(req: ConversationsRepliesRequest): ConversationsRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_REPLIES, req.token, ConversationsRepliesResponse::class.java)
  }


  override fun conversationsSetPurpose(req: ConversationsSetPurposeRequest): ConversationsSetPurposeResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("purpose", req.purpose, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_SET_PURPOSE, req.token, ConversationsSetPurposeResponse::class.java)
  }


  override fun conversationsSetTopic(req: ConversationsSetTopicRequest): ConversationsSetTopicResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("topic", req.topic, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_SET_TOPIC, req.token, ConversationsSetTopicResponse::class.java)
  }


  override fun conversationsUnarchive(req: ConversationsUnarchiveRequest): ConversationsUnarchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_UNARCHIVE, req.token, ConversationsUnarchiveResponse::class.java)
  }


  override fun dialogOpen(req: DialogOpenRequest): DialogOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("trigger_id", req.triggerId, form)
    if (req.dialog != null) {
      val json = GsonFactory.createSnakeCase().toJson(req.dialog)
      form.add("dialog", json)
    }

    return doPostFormWithToken(form, Methods.DIALOG_OPEN, req.token, DialogOpenResponse::class.java)
  }


  override fun dndEndDnd(req: DndEndDndRequest): DndEndDndResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.DND_END_DND, req.token, DndEndDndResponse::class.java)
  }


  override fun dndEndSnooze(req: DndEndSnoozeRequest): DndEndSnoozeResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.DND_END_SNOOZE, req.token, DndEndSnoozeResponse::class.java)
  }


  override fun dndInfo(req: DndInfoRequest): DndInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.DND_INFO, req.token, DndInfoResponse::class.java)
  }


  override fun dndSetSnooze(req: DndSetSnoozeRequest): DndSetSnoozeResponse {
    val form = FormBody.Builder()
    setIfNotNull("num_minutes", req.numMinutes, form)
    return doPostFormWithToken(form, Methods.DND_SET_SNOOZE, req.token, DndSetSnoozeResponse::class.java)
  }


  override fun dndTeamInfo(req: DndTeamInfoRequest): DndTeamInfoResponse {
    val form = FormBody.Builder()
    if (req.users != null) {
      setIfNotNull("user", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.DND_TEAM_INFO, req.token, DndTeamInfoResponse::class.java)
  }


  override fun emojiList(req: EmojiListRequest): EmojiListResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.EMOJI_LIST, req.token, EmojiListResponse::class.java)
  }


  override fun filesDelete(req: FilesDeleteRequest): FilesDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    return doPostFormWithToken(form, Methods.FILES_DELETE, req.token, FilesDeleteResponse::class.java)
  }


  override fun filesInfo(req: FilesInfoRequest): FilesInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.FILES_INFO, req.token, FilesInfoResponse::class.java)
  }


  override fun filesList(req: FilesListRequest): FilesListResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts_from", req.tsFrom, form)
    setIfNotNull("ts_to", req.tsTo, form)
    if (req.types != null) {
      setIfNotNull("types", req.types.joinToString(","), form)
    }
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.FILES_LIST, req.token, FilesListResponse::class.java)
  }


  override fun filesRevokePublicURL(req: FilesRevokePublicURLRequest): FilesRevokePublicURLResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    return doPostFormWithToken(form, Methods.FILES_REVOKE_PUBLIC_URL, req.token, FilesRevokePublicURLResponse::class.java)
  }


  override fun filesSharedPublicURL(req: FilesSharedPublicURLRequest): FilesSharedPublicURLResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    return doPostFormWithToken(form, Methods.FILES_SHARED_PUBLIC_URL, req.token, FilesSharedPublicURLResponse::class.java)
  }


  override fun filesUpload(req: FilesUploadRequest): FilesUploadResponse {
    if (req.file != null) {
      val form = MultipartBody.Builder()

      val file = RequestBody.create(MultipartBody.FORM, req.file)
      form.addFormDataPart("file", req.filename, file)

      setIfNotNull("filetype", req.filetype, form)
      setIfNotNull("filename", req.filename, form)
      setIfNotNull("title", req.title, form)
      setIfNotNull("initial_comment", req.initialComment, form)
      if (req.channels != null) {
        setIfNotNull("channels", req.channels.joinToString(","), form)
      }
      return doPostMultipart(form, Methods.FILES_UPLOAD, req.token, FilesUploadResponse::class.java)
    } else {
      val form = FormBody.Builder()

      setIfNotNull("content", req.content, form)
      setIfNotNull("filetype", req.filetype, form)
      setIfNotNull("filename", req.filename, form)
      setIfNotNull("title", req.title, form)
      setIfNotNull("initial_comment", req.initialComment, form)
      if (req.channels != null) {
        setIfNotNull("channels", req.channels.joinToString(","), form)
      }
      return doPostFormWithToken(form, Methods.FILES_UPLOAD, req.token, FilesUploadResponse::class.java)
    }
  }


  override fun filesCommentsAdd(req: FilesCommentsAddRequest): FilesCommentsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("comment", req.comment, form)
    return doPostFormWithToken(form, Methods.FILES_COMMENTS_ADD, req.token, FilesCommentsAddResponse::class.java)
  }


  override fun filesCommentsDelete(req: FilesCommentsDeleteRequest): FilesCommentsDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("id", req.id, form)
    return doPostFormWithToken(form, Methods.FILES_COMMENTS_DELETE, req.token, FilesCommentsDeleteResponse::class.java)
  }


  override fun filesCommentEdit(req: FilesCommentsEditRequest): FilesCommentsEditResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("comment", req.comment, form)
    setIfNotNull("id", req.id, form)
    return doPostFormWithToken(form, Methods.FILES_COMMENTS_EDIT, req.token, FilesCommentsEditResponse::class.java)
  }


  override fun groupsArchive(req: GroupsArchiveRequest): GroupsArchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_ARCHIVE, req.token, GroupsArchiveResponse::class.java)
  }


  override fun groupsClose(req: GroupsCloseRequest): GroupsCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_CLOSE, req.token, GroupsCloseResponse::class.java)
  }


  override fun groupsCreateChild(req: GroupsCreateChildRequest): GroupsCreateChildResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_CREATE_CHILD, req.token, GroupsCreateChildResponse::class.java)
  }


  override fun groupsCreate(req: GroupsCreateRequest): GroupsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.GROUPS_CREATE, req.token, GroupsCreateResponse::class.java)
  }


  override fun groupsHistory(req: GroupsHistoryRequest): GroupsHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.GROUPS_HISTORY, req.token, GroupsHistoryResponse::class.java)
  }


  override fun groupsReplies(req: GroupsRepliesRequest): GroupsRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.GROUPS_REPLIES, req.token, GroupsRepliesResponse::class.java)
  }


  override fun groupsInfo(req: GroupsInfoRequest): GroupsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.GROUPS_INFO, req.token, GroupsInfoResponse::class.java)
  }


  override fun groupsInvite(req: GroupsInviteRequest): GroupsInviteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.GROUPS_INVITE, req.token, GroupsInviteResponse::class.java)
  }


  override fun groupsKick(req: GroupsKickRequest): GroupsKickResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.GROUPS_KICK, req.token, GroupsKickResponse::class.java)
  }


  override fun groupsLeave(req: GroupsLeaveRequest): GroupsLeaveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_LEAVE, req.token, GroupsLeaveResponse::class.java)
  }


  override fun groupsList(req: GroupsListRequest): GroupsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    setIfNotNull("exclude_members", req.isExcludeMembers, form)
    return doPostFormWithToken(form, Methods.GROUPS_LIST, req.token, GroupsListResponse::class.java)
  }


  override fun groupsMark(req: GroupsMarkRequest): GroupsMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.GROUPS_MARK, req.token, GroupsMarkResponse::class.java)
  }


  override fun groupsOpen(req: GroupsOpenRequest): GroupsOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_OPEN, req.token, GroupsOpenResponse::class.java)
  }


  override fun groupsRename(req: GroupsRenameRequest): GroupsRenameResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("name", req.name, form)
    return doPostFormWithToken(form, Methods.GROUPS_RENAME, req.token, GroupsRenameResponse::class.java)
  }


  override fun groupsSetPurpose(req: GroupsSetPurposeRequest): GroupsSetPurposeResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("purpose", req.purpose, form)
    return doPostFormWithToken(form, Methods.GROUPS_SET_PURPOSE, req.token, GroupsSetPurposeResponse::class.java)
  }


  override fun groupsSetTopic(req: GroupsSetTopicRequest): GroupsSetTopicResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("topic", req.topic, form)
    return doPostFormWithToken(form, Methods.GROUPS_SET_TOPIC, req.token, GroupsSetTopicResponse::class.java)
  }


  override fun groupsUnarchive(req: GroupsUnarchiveRequest): GroupsUnarchiveResponse {
    val form = FormBody.Builder()

    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_UNARCHIVE, req.token, GroupsUnarchiveResponse::class.java)
  }


  override fun imClose(req: ImCloseRequest): ImCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.IM_CLOSE, req.token, ImCloseResponse::class.java)
  }


  override fun imHistory(req: ImHistoryRequest): ImHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.IM_HISTORY, req.token, ImHistoryResponse::class.java)
  }


  override fun imList(req: ImListRequest): ImListResponse {
    val form = FormBody.Builder()
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    return doPostFormWithToken(form, Methods.IM_LIST, req.token, ImListResponse::class.java)
  }


  override fun imMark(req: ImMarkRequest): ImMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.IM_MARK, req.token, ImMarkResponse::class.java)
  }


  override fun imOpen(req: ImOpenRequest): ImOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("return_im", req.isReturnIm, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.IM_OPEN, req.token, ImOpenResponse::class.java)
  }


  override fun imReplies(req: ImRepliesRequest): ImRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.IM_REPLIES, req.token, ImRepliesResponse::class.java)
  }


  override fun migrationExchange(req: MigrationExchangeRequest): MigrationExchangeResponse {
    val form = FormBody.Builder()
    setIfNotNull("to_old", req.isToOld, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.MIGRATION_EXCHANGE, req.token, MigrationExchangeResponse::class.java)
  }


  override fun mpimClose(req: MpimCloseRequest): MpimCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.MPIM_CLOSE, req.token, MpimCloseResponse::class.java)
  }


  override fun mpimHistory(req: MpimHistoryRequest): MpimHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.MPIM_HISTORY, req.token, MpimHistoryResponse::class.java)
  }


  override fun mpimList(req: MpimListRequest): MpimListResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.MPIM_LIST, req.token, MpimListResponse::class.java)
  }


  override fun mpimReplies(req: MpimRepliesRequest): MpimRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.MPIM_LIST, req.token, MpimRepliesResponse::class.java)
  }


  override fun mpimMark(req: MpimMarkRequest): MpimMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.MPIM_MARK, req.token, MpimMarkResponse::class.java)
  }


  override fun mpimOpen(req: MpimOpenRequest): MpimOpenResponse {
    val form = FormBody.Builder()
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.MPIM_OPEN, req.token, MpimOpenResponse::class.java)
  }


  override fun oauthAccess(req: OAuthAccessRequest): OAuthAccessResponse {
    val form = FormBody.Builder()
    setIfNotNull("client_id", req.clientId, form)
    setIfNotNull("client_secret", req.clientSecret, form)
    setIfNotNull("code", req.code, form)
    setIfNotNull("redirect_uri", req.redirectUri, form)
    setIfNotNull("single_channel", req.isSingleChannel, form)
    return doPostForm(form, Methods.OAUTH_ACCESS, OAuthAccessResponse::class.java)
  }


  override fun oauthToken(req: OAuthTokenRequest): OAuthTokenResponse {
    val form = FormBody.Builder()
    setIfNotNull("client_id", req.clientId, form)
    setIfNotNull("client_secret", req.clientSecret, form)
    setIfNotNull("code", req.code, form)
    setIfNotNull("redirect_uri", req.redirectUri, form)
    setIfNotNull("single_channel", req.isSingleChannel, form)
    return doPostForm(form, Methods.OAUTH_TOKEN, OAuthTokenResponse::class.java)
  }


  override fun pinsAdd(req: PinsAddRequest): PinsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.PINS_ADD, req.token, PinsAddResponse::class.java)
  }


  override fun pinsList(req: PinsListRequest): PinsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.PINS_LIST, req.token, PinsListResponse::class.java)
  }


  override fun pinsRemove(req: PinsRemoveRequest): PinsRemoveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.PINS_REMOVE, req.token, PinsRemoveResponse::class.java)
  }


  override fun reactionsAdd(req: ReactionsAddRequest): ReactionsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.REACTIONS_ADD, req.token, ReactionsAddResponse::class.java)
  }


  override fun reactionsGet(req: ReactionsGetRequest): ReactionsGetResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("timestamp", req.timestamp, form)
    setIfNotNull("full", req.isFull, form)
    return doPostFormWithToken(form, Methods.REACTIONS_GET, req.token, ReactionsGetResponse::class.java)
  }


  override fun reactionsList(req: ReactionsListRequest): ReactionsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("full", req.isFull, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.REACTIONS_LIST, req.token, ReactionsListResponse::class.java)
  }


  override fun reactionsRemove(req: ReactionsRemoveRequest): ReactionsRemoveResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.REACTIONS_REMOVE, req.token, ReactionsRemoveResponse::class.java)
  }


  override fun remindersAdd(req: RemindersAddRequest): RemindersAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("text", req.text, form)
    setIfNotNull("time", req.time, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.REMINDERS_ADD, req.token, RemindersAddResponse::class.java)
  }


  override fun remindersComplete(req: RemindersCompleteRequest): RemindersCompleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("reminder", req.reminder, form)
    return doPostFormWithToken(form, Methods.REMINDERS_COMPLETE, req.token, RemindersCompleteResponse::class.java)
  }


  override fun remindersDelete(req: RemindersDeleteRequest): RemindersDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("reminder", req.reminder, form)
    return doPostFormWithToken(form, Methods.REMINDERS_DELETE, req.token, RemindersDeleteResponse::class.java)
  }


  override fun remindersInfo(req: RemindersInfoRequest): RemindersInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("reminder", req.reminder, form)
    return doPostFormWithToken(form, Methods.REMINDERS_INFO, req.token, RemindersInfoResponse::class.java)
  }


  override fun remindersList(req: RemindersListRequest): RemindersListResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.REMINDERS_LIST, req.token, RemindersListResponse::class.java)
  }


  override fun rtmConnect(req: RTMConnectRequest): RTMConnectResponse {
    val form = FormBody.Builder()
    setIfNotNull("batch_presence_aware", req.isBatchPresenceAware, form)
    setIfNotNull("presence_sub", req.isPresenceSub, form)
    return doPostFormWithToken(form, Methods.RTM_CONNECT, req.token, RTMConnectResponse::class.java)
  }


  override fun rtmStart(req: RTMStartRequest): RTMStartResponse {
    val form = FormBody.Builder()
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    setIfNotNull("batch_presence_aware", req.isBatchPresenceAware, form)
    setIfNotNull("no_latest", req.isNoLatest, form)
    setIfNotNull("no_unreads", req.isNoUnreads, form)
    setIfNotNull("presence_sub", req.isPresenceSub, form)
    setIfNotNull("simple_latest", req.isSimpleLatest, form)
    setIfNotNull("mpim_aware", req.isMpimAware, form)
    return doPostFormWithToken(form, Methods.RTM_START, req.token, RTMStartResponse::class.java)
  }


  override fun searchAll(req: SearchAllRequest): SearchAllResponse {
    val form = FormBody.Builder()
    setIfNotNull("query", req.query, form)
    setIfNotNull("sort", req.sort, form)
    setIfNotNull("sort_dir", req.sortDir, form)
    setIfNotNull("highlight", req.isHighlight, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.SEARCH_ALL, req.token, SearchAllResponse::class.java)
  }


  override fun searchMessages(req: SearchMessagesRequest): SearchMessagesResponse {
    val form = FormBody.Builder()
    setIfNotNull("query", req.query, form)
    setIfNotNull("sort", req.sort, form)
    setIfNotNull("sort_dir", req.sortDir, form)
    setIfNotNull("highlight", req.isHighlight, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.SEARCH_MESSAGES, req.token, SearchMessagesResponse::class.java)
  }


  override fun searchFiles(req: SearchFilesRequest): SearchFilesResponse {
    val form = FormBody.Builder()
    setIfNotNull("query", req.query, form)
    setIfNotNull("sort", req.sort, form)
    setIfNotNull("sort_dir", req.sortDir, form)
    setIfNotNull("highlight", req.isHighlight, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.SEARCH_FILES, req.token, SearchFilesResponse::class.java)
  }


  override fun starsAdd(req: StarsAddRequest): StarsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.STARS_ADD, req.token, StarsAddResponse::class.java)
  }


  override fun starsList(req: StarsListRequest): StarsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.STARS_LIST, req.token, StarsListResponse::class.java)
  }


  override fun starsRemove(req: StarsRemoveRequest): StarsRemoveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.STARS_REMOVE, req.token, StarsRemoveResponse::class.java)
  }


  override fun teamAccessLogs(req: TeamAccessLogsRequest): TeamAccessLogsResponse {
    val form = FormBody.Builder()
    setIfNotNull("before", req.before, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.TEAM_ACCESS_LOGS, req.token, TeamAccessLogsResponse::class.java)
  }


  override fun teamBillableInfo(req: TeamBillableInfoRequest): TeamBillableInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.TEAM_BILLABLE_INFO, req.token, TeamBillableInfoResponse::class.java)
  }


  override fun teamInfo(req: TeamInfoRequest): TeamInfoResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.TEAM_INFO, req.token, TeamInfoResponse::class.java)
  }


  override fun teamIntegrationLogs(req: TeamIntegrationLogsRequest): TeamIntegrationLogsResponse {
    val form = FormBody.Builder()
    setIfNotNull("service_id", req.serviceId, form)
    setIfNotNull("user", req.user, form)
    setIfNotNull("change_type", req.changeType, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.TEAM_INTEGRATION_LOGS, req.token, TeamIntegrationLogsResponse::class.java)
  }


  override fun teamProfileGet(req: TeamProfileGetRequest): TeamProfileGetResponse {
    val form = FormBody.Builder()
    setIfNotNull("visibility", req.visibility, form)
    return doPostFormWithToken(form, Methods.TEAM_PROFILE_GET, req.token, TeamProfileGetResponse::class.java)
  }


  override fun usergroupsCreate(req: UsergroupsCreateRequest): UsergroupsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("handle", req.handle, form)
    setIfNotNull("description", req.description, form)
    if (req.channels != null) {
      setIfNotNull("channels", req.channels.joinToString(","), form)
    }
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_CREATE, req.token, UsergroupsCreateResponse::class.java)
  }


  override fun usergroupsDisable(req: UsergroupsDisableRequest): UsergroupsDisableResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_DISABLE, req.token, UsergroupsDisableResponse::class.java)
  }


  override fun usergroupsEnable(req: UsergroupsEnableRequest): UsergroupsEnableResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_ENABLE, req.token, UsergroupsEnableResponse::class.java)
  }


  override fun usergroupsList(req: UsergroupsListRequest): UsergroupsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("include_disabled", req.isIncludeDisabled, form)
    setIfNotNull("include_count", req.isIncludeCount, form)
    setIfNotNull("include_users", req.isIncludeUsers, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_LIST, req.token, UsergroupsListResponse::class.java)
  }


  override fun usergroupsUpdate(req: UsergroupsUpdateRequest): UsergroupsUpdateResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("name", req.name, form)
    setIfNotNull("handle", req.handle, form)
    setIfNotNull("description", req.description, form)
    if (req.channels != null) {
      setIfNotNull("channels", req.channels.joinToString(","), form)
    }
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_UPDATE, req.token, UsergroupsUpdateResponse::class.java)
  }


  override fun usergroupUsersList(req: UsergroupUsersListRequest): UsergroupUsersListResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("include_disabled", req.isIncludeDisabled, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_USERS_LIST, req.token, UsergroupUsersListResponse::class.java)
  }


  override fun usergroupUsersUpdate(req: UsergroupUsersUpdateRequest): UsergroupUsersUpdateResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_USERS_UPDATE, req.token, UsergroupUsersUpdateResponse::class.java)
  }


  override fun usersConversations(req: UsersConversationsRequest): UsersConversationsResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    setIfNotNull("limit", req.limit, form)

    if (req.types != null) {
      val typeValues = ArrayList<String>()
      for (type in req.types) {
        typeValues.add(type.value())
      }
      setIfNotNull("types", typeValues.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.USERS_CONVERSATIONS, req.token, UsersConversationsResponse::class.java)
  }


  override fun usersDeletePhoto(req: UsersDeletePhotoRequest): UsersDeletePhotoResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.USERS_DELETE_PHOTO, req.token, UsersDeletePhotoResponse::class.java)
  }


  override fun usersGetPresence(req: UsersGetPresenceRequest): UsersGetPresenceResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.USERS_GET_PRESENCE, req.token, UsersGetPresenceResponse::class.java)
  }


  override fun usersIdentity(req: UsersIdentityRequest): UsersIdentityResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.USERS_IDENTITY, req.token, UsersIdentityResponse::class.java)
  }


  override fun usersInfo(req: UsersInfoRequest): UsersInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.USERS_INFO, req.token, UsersInfoResponse::class.java)
  }


  override fun usersList(req: UsersListRequest): UsersListResponse {
    val form = FormBody.Builder()
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    setIfNotNull("presence", req.isPresence, form)
    return doPostFormWithToken(form, Methods.USERS_LIST, req.token, UsersListResponse::class.java)
  }


  override fun usersLookupByEmail(req: UsersLookupByEmailRequest): UsersLookupByEmailResponse {
    val form = FormBody.Builder()
    setIfNotNull("email", req.email, form)
    return doPostFormWithToken(form, Methods.USERS_LOOKUP_BY_EMAIL, req.token, UsersLookupByEmailResponse::class.java)
  }


  override fun usersSetActive(req: UsersSetActiveRequest): UsersSetActiveResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.USERS_SET_ACTIVE, req.token, UsersSetActiveResponse::class.java)
  }


  override fun usersSetPhoto(req: UsersSetPhotoRequest): UsersSetPhotoResponse {
    val form = MultipartBody.Builder()
    val image = RequestBody.create(MediaType.parse("image/*"), req.image)
    form.addFormDataPart("image", "image", image)
    setIfNotNull("crop_x", req.cropX, form)
    setIfNotNull("crop_y", req.cropY, form)
    setIfNotNull("crop_w", req.cropW, form)
    return doPostMultipart(form, Methods.USERS_SET_PHOTO, req.token, UsersSetPhotoResponse::class.java)
  }


  override fun usersSetPresence(req: UsersSetPresenceRequest): UsersSetPresenceResponse {
    val form = FormBody.Builder()
    setIfNotNull("presence", req.presence, form)
    return doPostFormWithToken(form, Methods.USERS_SET_PRESENCE, req.token, UsersSetPresenceResponse::class.java)
  }


  override fun usersProfileGet(req: UsersProfileGetRequest): UsersProfileGetResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("include_labels", req.isIncludeLabels, form)
    return doPostFormWithToken(form, Methods.USERS_PROFILE_GET, req.token, UsersProfileGetResponse::class.java)
  }


  override fun usersProfileSet(req: UsersProfileSetRequest): UsersProfileSetResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    if (req.profile != null) {
      setIfNotNull("profile", GsonFactory.createSnakeCase().toJson(req.profile), form)
    } else {
      setIfNotNull("name", req.name, form)
      setIfNotNull("value", req.value, form)
    }
    return doPostFormWithToken(form, Methods.USERS_PROFILE_SET, req.token, UsersProfileSetResponse::class.java)
  }

  // ----------------------------------------------------------------------------------
  // private methods
  // ----------------------------------------------------------------------------------

  private fun setIfNotNull(name: String, value: Any?, form: FormBody.Builder) {
    if (value != null) {
      if (value is Boolean) {
        val numValue = if (value) "1" else "0"
        form.add(name, numValue)
      } else {
        form.add(name, value.toString())
      }
    }
  }

  private fun setIfNotNull(name: String, value: Any?, form: MultipartBody.Builder) {
    if (value != null) {
      if (value is Boolean) {
        val numValue = if (value) "1" else "0"
        form.addFormDataPart(name, numValue)
      } else {
        form.addFormDataPart(name, value.toString())
      }
    }
  }


  protected fun <T> doPostForm(
      form: FormBody.Builder,
      endpoint: String,
      clazz: Class<T>): T {
    val response = slackHttpClient.postForm(endpointUrlPrefix + endpoint, form.build())
    return SlackHttpClient.buildJsonResponse(response, clazz)
  }


  protected fun <T> doPostFormWithToken(
      form: FormBody.Builder,
      endpoint: String,
      token: String,
      clazz: Class<T>): T {
    val response = slackHttpClient.postFormWithBearerHeader(endpointUrlPrefix + endpoint, token, form.build())
    return SlackHttpClient.buildJsonResponse(response, clazz)
  }


  protected fun <T> doPostMultipart(
      form: MultipartBody.Builder,
      endpoint: String,
      token: String,
      clazz: Class<T>): T {
    form.setType(MultipartBody.FORM)
    val response = slackHttpClient.postMultipart(endpointUrlPrefix + endpoint, token, form.build())
    return SlackHttpClient.buildJsonResponse(response, clazz)
  }
}