package io.mverse.kslack.api.methods.impl

import io.mverse.kslack.api.methods.Methods
import io.mverse.kslack.api.methods.MethodsClient
import io.mverse.kslack.api.methods.SlackApiRequest
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
import io.mverse.kslack.common.http.SlackHttpClient
import io.mverse.kslack.common.json.GsonFactory
import io.mverse.kslack.shortcut.model.ApiToken
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.util.*

data class MethodsClientImpl(private val slackHttpClient: SlackHttpClient,
                             val defaultToken: ApiToken? = null) : MethodsClient {

  override var endpointUrlPrefix = "https://slack.com/api/"

  // ----------------------------------------------------------------------------------
  // public methods
  // ----------------------------------------------------------------------------------


  override fun apiTest(req: ApiTestRequest): ApiTestResponse {
    val form = FormBody.Builder()
    setIfNotNull("foo", req.foo, form)
    setIfNotNull("error", req.error, form)
    return doPostForm(form, Methods.API_TEST, ApiTestResponse::class.java)
  }

  private val SlackApiRequest.tokenOrDefault: String get() {
    return this.token ?: defaultToken ?: throw IllegalStateException("No api token could be located")
  }

  override fun appsPermissionsInfo(req: AppsPermissionsInfoRequest): AppsPermissionsInfoResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.APPS_PERMISSIONS_INFO, req.tokenOrDefault, AppsPermissionsInfoResponse::class.java)
  }


  override fun appsPermissionsRequest(req: AppsPermissionsRequestRequest): AppsPermissionsRequestResponse {
    val form = FormBody.Builder()
    setIfNotNull("trigger_id", req.triggerId, form)
    if (req.scopes != null) {
      setIfNotNull("scopes", req.scopes.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.APPS_PERMISSIONS_REQUEST, req.tokenOrDefault, AppsPermissionsRequestResponse::class.java)
  }


  override fun authRevoke(req: AuthRevokeRequest): AuthRevokeResponse {
    val form = FormBody.Builder()
    setIfNotNull("test", req.isTest, form)
    return doPostFormWithToken(form, Methods.AUTH_REVOKE, req.tokenOrDefault, AuthRevokeResponse::class.java)
  }


  override fun authTest(req: AuthTestRequest): AuthTestResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.AUTH_TEST, req.tokenOrDefault, AuthTestResponse::class.java)
  }


  override fun botsInfo(req: BotsInfoRequest): BotsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("bot", req.bot, form)
    return doPostFormWithToken(form, Methods.BOTS_INFO, req.tokenOrDefault, BotsInfoResponse::class.java)
  }


  override fun channelsArchive(req: ChannelsArchiveRequest): ChannelsArchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CHANNELS_ARCHIVE, req.tokenOrDefault, ChannelsArchiveResponse::class.java)
  }


  override fun channelsCreate(req: ChannelsCreateRequest): ChannelsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.CHANNELS_CREATE, req.tokenOrDefault, ChannelsCreateResponse::class.java)
  }


  override fun channelsHistory(req: ChannelsHistoryRequest): ChannelsHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.CHANNELS_HISTORY, req.tokenOrDefault, ChannelsHistoryResponse::class.java)
  }


  override fun channelsReplies(req: ChannelsRepliesRequest): ChannelsRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.CHANNELS_REPLIES, req.tokenOrDefault, ChannelsRepliesResponse::class.java)
  }


  override fun channelsInfo(req: ChannelsInfoRequest): ChannelsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.CHANNELS_INFO, req.tokenOrDefault, ChannelsInfoResponse::class.java)
  }


  override fun channelsList(req: ChannelsListRequest): ChannelsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("limit", req.limit, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("exclude_members", req.isExcludeMembers, form)
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    return doPostFormWithToken(form, Methods.CHANNELS_LIST, req.tokenOrDefault, ChannelsListResponse::class.java)
  }


  override fun channelsInvite(req: ChannelsInviteRequest): ChannelsInviteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.CHANNELS_INVITE, req.tokenOrDefault, ChannelsInviteResponse::class.java)
  }


  override fun channelsJoin(req: ChannelsJoinRequest): ChannelsJoinResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.CHANNELS_JOIN, req.tokenOrDefault, ChannelsJoinResponse::class.java)
  }


  override fun channelsKick(req: ChannelsKickRequest): ChannelsKickResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.CHANNELS_KICK, req.tokenOrDefault, ChannelsKickResponse::class.java)
  }


  override fun channelsLeave(req: ChannelsLeaveRequest): ChannelsLeaveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CHANNELS_LEAVE, req.tokenOrDefault, ChannelsLeaveResponse::class.java)
  }


  override fun channelsMark(req: ChannelsMarkRequest): ChannelsMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.CHANNELS_MARK, req.tokenOrDefault, ChannelsMarkResponse::class.java)
  }


  override fun channelsRename(req: ChannelsRenameRequest): ChannelsRenameResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.CHANNELS_RENAME, req.tokenOrDefault, ChannelsRenameResponse::class.java)
  }


  override fun channelsSetPurpose(req: ChannelsSetPurposeRequest): ChannelsSetPurposeResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("purpose", req.purpose, form)
    return doPostFormWithToken(form, Methods.CHANNELS_SET_PURPOSE, req.tokenOrDefault, ChannelsSetPurposeResponse::class.java)
  }


  override fun channelsSetTopic(req: ChannelsSetTopicRequest): ChannelsSetTopicResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("topic", req.topic, form)
    return doPostFormWithToken(form, Methods.CHANNELS_SET_TOPIC, req.tokenOrDefault, ChannelsSetTopicResponse::class.java)
  }


  override fun channelsUnarchive(req: ChannelsUnarchiveRequest): ChannelsUnarchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CHANNELS_UNARCHIVE, req.tokenOrDefault, ChannelsUnarchiveResponse::class.java)
  }


  override fun chatGetPermalink(req: ChatGetPermalinkRequest): ChatGetPermalinkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("message_ts", req.messageTs, form)
    return doPostFormWithToken(form, Methods.CHAT_GET_PERMALINK, req.tokenOrDefault, ChatGetPermalinkResponse::class.java)
  }


  override fun chatDelete(req: ChatDeleteRequest): ChatDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.CHAT_DELETE, req.tokenOrDefault, ChatDeleteResponse::class.java)
  }


  override fun chatMeMessage(req: ChatMeMessageRequest): ChatMeMessageResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("text", req.text, form)
    return doPostFormWithToken(form, Methods.CHAT_ME_MESSAGE, req.tokenOrDefault, ChatMeMessageResponse::class.java)
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
    return doPostFormWithToken(form, Methods.CHAT_POST_EPHEMERAL, req.tokenOrDefault, ChatPostEphemeralResponse::class.java)
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
    return doPostFormWithToken(form, Methods.CHAT_POST_MESSAGE, req.tokenOrDefault, ChatPostMessageResponse::class.java)
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
    return doPostFormWithToken(form, Methods.CHAT_UPDATE, req.tokenOrDefault, ChatUpdateResponse::class.java)
  }


  override fun chatUnfurl(req: ChatUnfurlRequest): ChatUnfurlResponse {
    val form = FormBody.Builder()
    setIfNotNull("ts", req.ts, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("unfurls", req.unfurls, form)
    setIfNotNull("user_auth_required", req.isUserAuthRequired, form)
    setIfNotNull("user_auth_message", req.userAuthMessage, form)
    setIfNotNull("user_auth_url", req.userAuthUrl, form)
    return doPostFormWithToken(form, Methods.CHAT_UNFURL, req.tokenOrDefault, ChatUnfurlResponse::class.java)
  }


  override fun conversationsArchive(req: ConversationsArchiveRequest): ConversationsArchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_ARCHIVE, req.tokenOrDefault, ConversationsArchiveResponse::class.java)
  }


  override fun conversationsClose(req: ConversationsCloseRequest): ConversationsCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_CLOSE, req.tokenOrDefault, ConversationsCloseResponse::class.java)
  }


  override fun conversationsCreate(req: ConversationsCreateRequest): ConversationsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("is_private", req.isPrivate, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_CREATE, req.tokenOrDefault, ConversationsCreateResponse::class.java)
  }


  override fun conversationsHistory(req: ConversationsHistoryRequest): ConversationsHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("limit", req.limit, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_HISTORY, req.tokenOrDefault, ConversationsHistoryResponse::class.java)
  }


  override fun conversationsInfo(req: ConversationsInfoRequest): ConversationsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_INFO, req.tokenOrDefault, ConversationsInfoResponse::class.java)
  }


  override fun conversationsInvite(req: ConversationsInviteRequest): ConversationsInviteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.CONVERSATIONS_INVITE, req.tokenOrDefault, ConversationsInviteResponse::class.java)
  }


  override fun conversationsJoin(req: ConversationsJoinRequest): ConversationsJoinResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_JOIN, req.tokenOrDefault, ConversationsJoinResponse::class.java)
  }


  override fun conversationsKick(req: ConversationsKickRequest): ConversationsKickResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_KICK, req.tokenOrDefault, ConversationsKickResponse::class.java)
  }


  override fun conversationsLeave(req: ConversationsLeaveRequest): ConversationsLeaveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_LEAVE, req.tokenOrDefault, ConversationsLeaveResponse::class.java)
  }


  override fun conversationsList(req: ConversationsListRequest): ConversationsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    setIfNotNull("limit", req.limit, form)

    if (req.types != null) {
      val typeValues = ArrayList<String>()
      for (type in req.types) {
        typeValues.add(type.value)
      }
      setIfNotNull("types", typeValues.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.CONVERSATIONS_LIST, req.tokenOrDefault, ConversationsListResponse::class.java)
  }


  override fun conversationsMembers(req: ConversationsMembersRequest): ConversationsMembersResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_MEMBERS, req.tokenOrDefault, ConversationsMembersResponse::class.java)
  }


  override fun conversationsOpen(req: ConversationsOpenRequest): ConversationsOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("return_im", req.isReturnIm, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.CONVERSATIONS_OPEN, req.tokenOrDefault, ConversationsOpenResponse::class.java)
  }


  override fun conversationsRename(req: ConversationsRenameRequest): ConversationsRenameResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("name", req.name, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_RENAME, req.tokenOrDefault, ConversationsRenameResponse::class.java)
  }


  override fun conversationsReplies(req: ConversationsRepliesRequest): ConversationsRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_REPLIES, req.tokenOrDefault, ConversationsRepliesResponse::class.java)
  }


  override fun conversationsSetPurpose(req: ConversationsSetPurposeRequest): ConversationsSetPurposeResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("purpose", req.purpose, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_SET_PURPOSE, req.tokenOrDefault, ConversationsSetPurposeResponse::class.java)
  }


  override fun conversationsSetTopic(req: ConversationsSetTopicRequest): ConversationsSetTopicResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("topic", req.topic, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_SET_TOPIC, req.tokenOrDefault, ConversationsSetTopicResponse::class.java)
  }


  override fun conversationsUnarchive(req: ConversationsUnarchiveRequest): ConversationsUnarchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.CONVERSATIONS_UNARCHIVE, req.tokenOrDefault, ConversationsUnarchiveResponse::class.java)
  }


  override fun dialogOpen(req: DialogOpenRequest): DialogOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("trigger_id", req.triggerId, form)
    val json = GsonFactory.createSnakeCase().toJson(req.dialog)
    form.add("dialog", json)

    return doPostFormWithToken(form, Methods.DIALOG_OPEN, req.tokenOrDefault, DialogOpenResponse::class.java)
  }


  override fun dndEndDnd(req: DndEndDndRequest): DndEndDndResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.DND_END_DND, req.tokenOrDefault, DndEndDndResponse::class.java)
  }


  override fun dndEndSnooze(req: DndEndSnoozeRequest): DndEndSnoozeResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.DND_END_SNOOZE, req.tokenOrDefault, DndEndSnoozeResponse::class.java)
  }


  override fun dndInfo(req: DndInfoRequest): DndInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.DND_INFO, req.tokenOrDefault, DndInfoResponse::class.java)
  }


  override fun dndSetSnooze(req: DndSetSnoozeRequest): DndSetSnoozeResponse {
    val form = FormBody.Builder()
    setIfNotNull("num_minutes", req.numMinutes, form)
    return doPostFormWithToken(form, Methods.DND_SET_SNOOZE, req.tokenOrDefault, DndSetSnoozeResponse::class.java)
  }


  override fun dndTeamInfo(req: DndTeamInfoRequest): DndTeamInfoResponse {
    val form = FormBody.Builder()
    if (req.users != null) {
      setIfNotNull("user", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.DND_TEAM_INFO, req.tokenOrDefault, DndTeamInfoResponse::class.java)
  }


  override fun emojiList(req: EmojiListRequest): EmojiListResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.EMOJI_LIST, req.tokenOrDefault, EmojiListResponse::class.java)
  }


  override fun filesDelete(req: FilesDeleteRequest): FilesDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    return doPostFormWithToken(form, Methods.FILES_DELETE, req.tokenOrDefault, FilesDeleteResponse::class.java)
  }


  override fun filesInfo(req: FilesInfoRequest): FilesInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.FILES_INFO, req.tokenOrDefault, FilesInfoResponse::class.java)
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
    return doPostFormWithToken(form, Methods.FILES_LIST, req.tokenOrDefault, FilesListResponse::class.java)
  }


  override fun filesRevokePublicURL(req: FilesRevokePublicURLRequest): FilesRevokePublicURLResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    return doPostFormWithToken(form, Methods.FILES_REVOKE_PUBLIC_URL, req.tokenOrDefault, FilesRevokePublicURLResponse::class.java)
  }


  override fun filesSharedPublicURL(req: FilesSharedPublicURLRequest): FilesSharedPublicURLResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    return doPostFormWithToken(form, Methods.FILES_SHARED_PUBLIC_URL, req.tokenOrDefault, FilesSharedPublicURLResponse::class.java)
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
      return doPostMultipart(form, Methods.FILES_UPLOAD, req.tokenOrDefault, FilesUploadResponse::class.java)
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
      return doPostFormWithToken(form, Methods.FILES_UPLOAD, req.tokenOrDefault, FilesUploadResponse::class.java)
    }
  }


  override fun filesCommentsAdd(req: FilesCommentsAddRequest): FilesCommentsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("comment", req.comment, form)
    return doPostFormWithToken(form, Methods.FILES_COMMENTS_ADD, req.tokenOrDefault, FilesCommentsAddResponse::class.java)
  }


  override fun filesCommentsDelete(req: FilesCommentsDeleteRequest): FilesCommentsDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("id", req.id, form)
    return doPostFormWithToken(form, Methods.FILES_COMMENTS_DELETE, req.tokenOrDefault, FilesCommentsDeleteResponse::class.java)
  }


  override fun filesCommentEdit(req: FilesCommentsEditRequest): FilesCommentsEditResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("comment", req.comment, form)
    setIfNotNull("id", req.id, form)
    return doPostFormWithToken(form, Methods.FILES_COMMENTS_EDIT, req.tokenOrDefault, FilesCommentsEditResponse::class.java)
  }


  override fun groupsArchive(req: GroupsArchiveRequest): GroupsArchiveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_ARCHIVE, req.tokenOrDefault, GroupsArchiveResponse::class.java)
  }


  override fun groupsClose(req: GroupsCloseRequest): GroupsCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_CLOSE, req.tokenOrDefault, GroupsCloseResponse::class.java)
  }


  override fun groupsCreateChild(req: GroupsCreateChildRequest): GroupsCreateChildResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_CREATE_CHILD, req.tokenOrDefault, GroupsCreateChildResponse::class.java)
  }


  override fun groupsCreate(req: GroupsCreateRequest): GroupsCreateResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("validate", req.isValidate, form)
    return doPostFormWithToken(form, Methods.GROUPS_CREATE, req.tokenOrDefault, GroupsCreateResponse::class.java)
  }


  override fun groupsHistory(req: GroupsHistoryRequest): GroupsHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.GROUPS_HISTORY, req.tokenOrDefault, GroupsHistoryResponse::class.java)
  }


  override fun groupsReplies(req: GroupsRepliesRequest): GroupsRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.GROUPS_REPLIES, req.tokenOrDefault, GroupsRepliesResponse::class.java)
  }


  override fun groupsInfo(req: GroupsInfoRequest): GroupsInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.GROUPS_INFO, req.tokenOrDefault, GroupsInfoResponse::class.java)
  }


  override fun groupsInvite(req: GroupsInviteRequest): GroupsInviteResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.GROUPS_INVITE, req.tokenOrDefault, GroupsInviteResponse::class.java)
  }


  override fun groupsKick(req: GroupsKickRequest): GroupsKickResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.GROUPS_KICK, req.tokenOrDefault, GroupsKickResponse::class.java)
  }


  override fun groupsLeave(req: GroupsLeaveRequest): GroupsLeaveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_LEAVE, req.tokenOrDefault, GroupsLeaveResponse::class.java)
  }


  override fun groupsList(req: GroupsListRequest): GroupsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("exclude_archived", req.isExcludeArchived, form)
    setIfNotNull("exclude_members", req.isExcludeMembers, form)
    return doPostFormWithToken(form, Methods.GROUPS_LIST, req.tokenOrDefault, GroupsListResponse::class.java)
  }


  override fun groupsMark(req: GroupsMarkRequest): GroupsMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.GROUPS_MARK, req.tokenOrDefault, GroupsMarkResponse::class.java)
  }


  override fun groupsOpen(req: GroupsOpenRequest): GroupsOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_OPEN, req.tokenOrDefault, GroupsOpenResponse::class.java)
  }


  override fun groupsRename(req: GroupsRenameRequest): GroupsRenameResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("name", req.name, form)
    return doPostFormWithToken(form, Methods.GROUPS_RENAME, req.tokenOrDefault, GroupsRenameResponse::class.java)
  }


  override fun groupsSetPurpose(req: GroupsSetPurposeRequest): GroupsSetPurposeResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("purpose", req.purpose, form)
    return doPostFormWithToken(form, Methods.GROUPS_SET_PURPOSE, req.tokenOrDefault, GroupsSetPurposeResponse::class.java)
  }


  override fun groupsSetTopic(req: GroupsSetTopicRequest): GroupsSetTopicResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("topic", req.topic, form)
    return doPostFormWithToken(form, Methods.GROUPS_SET_TOPIC, req.tokenOrDefault, GroupsSetTopicResponse::class.java)
  }


  override fun groupsUnarchive(req: GroupsUnarchiveRequest): GroupsUnarchiveResponse {
    val form = FormBody.Builder()

    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.GROUPS_UNARCHIVE, req.tokenOrDefault, GroupsUnarchiveResponse::class.java)
  }


  override fun imClose(req: ImCloseRequest): ImCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.IM_CLOSE, req.tokenOrDefault, ImCloseResponse::class.java)
  }


  override fun imHistory(req: ImHistoryRequest): ImHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.IM_HISTORY, req.tokenOrDefault, ImHistoryResponse::class.java)
  }


  override fun imList(req: ImListRequest): ImListResponse {
    val form = FormBody.Builder()
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    return doPostFormWithToken(form, Methods.IM_LIST, req.tokenOrDefault, ImListResponse::class.java)
  }


  override fun imMark(req: ImMarkRequest): ImMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.IM_MARK, req.tokenOrDefault, ImMarkResponse::class.java)
  }


  override fun imOpen(req: ImOpenRequest): ImOpenResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("return_im", req.isReturnIm, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.IM_OPEN, req.tokenOrDefault, ImOpenResponse::class.java)
  }


  override fun imReplies(req: ImRepliesRequest): ImRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.IM_REPLIES, req.tokenOrDefault, ImRepliesResponse::class.java)
  }


  override fun migrationExchange(req: MigrationExchangeRequest): MigrationExchangeResponse {
    val form = FormBody.Builder()
    setIfNotNull("to_old", req.isToOld, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.MIGRATION_EXCHANGE, req.tokenOrDefault, MigrationExchangeResponse::class.java)
  }


  override fun mpimClose(req: MpimCloseRequest): MpimCloseResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.MPIM_CLOSE, req.tokenOrDefault, MpimCloseResponse::class.java)
  }


  override fun mpimHistory(req: MpimHistoryRequest): MpimHistoryResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("latest", req.latest, form)
    setIfNotNull("oldest", req.oldest, form)
    setIfNotNull("inclusive", req.isInclusive, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("unreads", req.isUnreads, form)
    return doPostFormWithToken(form, Methods.MPIM_HISTORY, req.tokenOrDefault, MpimHistoryResponse::class.java)
  }


  override fun mpimList(req: MpimListRequest): MpimListResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.MPIM_LIST, req.tokenOrDefault, MpimListResponse::class.java)
  }


  override fun mpimReplies(req: MpimRepliesRequest): MpimRepliesResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("thread_ts", req.threadTs, form)
    return doPostFormWithToken(form, Methods.MPIM_LIST, req.tokenOrDefault, MpimRepliesResponse::class.java)
  }


  override fun mpimMark(req: MpimMarkRequest): MpimMarkResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("ts", req.ts, form)
    return doPostFormWithToken(form, Methods.MPIM_MARK, req.tokenOrDefault, MpimMarkResponse::class.java)
  }


  override fun mpimOpen(req: MpimOpenRequest): MpimOpenResponse {
    val form = FormBody.Builder()
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.MPIM_OPEN, req.tokenOrDefault, MpimOpenResponse::class.java)
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
    return doPostFormWithToken(form, Methods.PINS_ADD, req.tokenOrDefault, PinsAddResponse::class.java)
  }


  override fun pinsList(req: PinsListRequest): PinsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    return doPostFormWithToken(form, Methods.PINS_LIST, req.tokenOrDefault, PinsListResponse::class.java)
  }

  override fun pinsRemove(req: PinsRemoveRequest): PinsRemoveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.PINS_REMOVE, req.tokenOrDefault, PinsRemoveResponse::class.java)
  }

  override fun reactionsAdd(req: ReactionsAddRequest): ReactionsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.REACTIONS_ADD, req.tokenOrDefault, ReactionsAddResponse::class.java)
  }

  override fun reactionsGet(req: ReactionsGetRequest): ReactionsGetResponse {
    val form = FormBody.Builder()
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("timestamp", req.timestamp, form)
    setIfNotNull("full", req.isFull, form)
    return doPostFormWithToken(form, Methods.REACTIONS_GET, req.tokenOrDefault, ReactionsGetResponse::class.java)
  }

  override fun reactionsList(req: ReactionsListRequest): ReactionsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("full", req.isFull, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.REACTIONS_LIST, req.tokenOrDefault, ReactionsListResponse::class.java)
  }

  override fun reactionsRemove(req: ReactionsRemoveRequest): ReactionsRemoveResponse {
    val form = FormBody.Builder()
    setIfNotNull("name", req.name, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.REACTIONS_REMOVE, req.tokenOrDefault, ReactionsRemoveResponse::class.java)
  }

  override fun remindersAdd(req: RemindersAddRequest): RemindersAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("text", req.text, form)
    setIfNotNull("time", req.time, form)
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.REMINDERS_ADD, req.tokenOrDefault, RemindersAddResponse::class.java)
  }

  override fun remindersComplete(req: RemindersCompleteRequest): RemindersCompleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("reminder", req.reminder, form)
    return doPostFormWithToken(form, Methods.REMINDERS_COMPLETE, req.tokenOrDefault, RemindersCompleteResponse::class.java)
  }

  override fun remindersDelete(req: RemindersDeleteRequest): RemindersDeleteResponse {
    val form = FormBody.Builder()
    setIfNotNull("reminder", req.reminder, form)
    return doPostFormWithToken(form, Methods.REMINDERS_DELETE, req.tokenOrDefault, RemindersDeleteResponse::class.java)
  }

  override fun remindersInfo(req: RemindersInfoRequest): RemindersInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("reminder", req.reminder, form)
    return doPostFormWithToken(form, Methods.REMINDERS_INFO, req.tokenOrDefault, RemindersInfoResponse::class.java)
  }

  override fun remindersList(req: RemindersListRequest): RemindersListResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.REMINDERS_LIST, req.tokenOrDefault, RemindersListResponse::class.java)
  }

  override fun rtmConnect(req: RTMConnectRequest): RTMConnectResponse {
    val form = FormBody.Builder()
    setIfNotNull("batch_presence_aware", req.isBatchPresenceAware, form)
    setIfNotNull("presence_sub", req.isPresenceSub, form)
    return doPostFormWithToken(form, Methods.RTM_CONNECT, req.tokenOrDefault, RTMConnectResponse::class.java)
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
    return doPostFormWithToken(form, Methods.RTM_START, req.tokenOrDefault, RTMStartResponse::class.java)
  }

  override fun searchAll(req: SearchAllRequest): SearchAllResponse {
    val form = FormBody.Builder()
    setIfNotNull("query", req.query, form)
    setIfNotNull("sort", req.sort, form)
    setIfNotNull("sort_dir", req.sortDir, form)
    setIfNotNull("highlight", req.isHighlight, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.SEARCH_ALL, req.tokenOrDefault, SearchAllResponse::class.java)
  }

  override fun searchMessages(req: SearchMessagesRequest): SearchMessagesResponse {
    val form = FormBody.Builder()
    setIfNotNull("query", req.query, form)
    setIfNotNull("sort", req.sort, form)
    setIfNotNull("sort_dir", req.sortDir, form)
    setIfNotNull("highlight", req.isHighlight, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.SEARCH_MESSAGES, req.tokenOrDefault, SearchMessagesResponse::class.java)
  }

  override fun searchFiles(req: SearchFilesRequest): SearchFilesResponse {
    val form = FormBody.Builder()
    setIfNotNull("query", req.query, form)
    setIfNotNull("sort", req.sort, form)
    setIfNotNull("sort_dir", req.sortDir, form)
    setIfNotNull("highlight", req.isHighlight, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.SEARCH_FILES, req.tokenOrDefault, SearchFilesResponse::class.java)
  }

  override fun starsAdd(req: StarsAddRequest): StarsAddResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.STARS_ADD, req.tokenOrDefault, StarsAddResponse::class.java)
  }

  override fun starsList(req: StarsListRequest): StarsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.STARS_LIST, req.tokenOrDefault, StarsListResponse::class.java)
  }

  override fun starsRemove(req: StarsRemoveRequest): StarsRemoveResponse {
    val form = FormBody.Builder()
    setIfNotNull("channel", req.channel, form)
    setIfNotNull("file", req.file, form)
    setIfNotNull("file_comment", req.fileComment, form)
    setIfNotNull("timestamp", req.timestamp, form)
    return doPostFormWithToken(form, Methods.STARS_REMOVE, req.tokenOrDefault, StarsRemoveResponse::class.java)
  }

  override fun teamAccessLogs(req: TeamAccessLogsRequest): TeamAccessLogsResponse {
    val form = FormBody.Builder()
    setIfNotNull("before", req.before, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.TEAM_ACCESS_LOGS, req.tokenOrDefault, TeamAccessLogsResponse::class.java)
  }

  override fun teamBillableInfo(req: TeamBillableInfoRequest): TeamBillableInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.TEAM_BILLABLE_INFO, req.tokenOrDefault, TeamBillableInfoResponse::class.java)
  }

  override fun teamInfo(req: TeamInfoRequest): TeamInfoResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.TEAM_INFO, req.tokenOrDefault, TeamInfoResponse::class.java)
  }

  override fun teamIntegrationLogs(req: TeamIntegrationLogsRequest): TeamIntegrationLogsResponse {
    val form = FormBody.Builder()
    setIfNotNull("service_id", req.serviceId, form)
    setIfNotNull("user", req.user, form)
    setIfNotNull("change_type", req.changeType, form)
    setIfNotNull("count", req.count, form)
    setIfNotNull("page", req.page, form)
    return doPostFormWithToken(form, Methods.TEAM_INTEGRATION_LOGS, req.tokenOrDefault, TeamIntegrationLogsResponse::class.java)
  }

  override fun teamProfileGet(req: TeamProfileGetRequest): TeamProfileGetResponse {
    val form = FormBody.Builder()
    setIfNotNull("visibility", req.visibility, form)
    return doPostFormWithToken(form, Methods.TEAM_PROFILE_GET, req.tokenOrDefault, TeamProfileGetResponse::class.java)
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
    return doPostFormWithToken(form, Methods.USERGROUPS_CREATE, req.tokenOrDefault, UsergroupsCreateResponse::class.java)
  }

  override fun usergroupsDisable(req: UsergroupsDisableRequest): UsergroupsDisableResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_DISABLE, req.tokenOrDefault, UsergroupsDisableResponse::class.java)
  }

  override fun usergroupsEnable(req: UsergroupsEnableRequest): UsergroupsEnableResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_ENABLE, req.tokenOrDefault, UsergroupsEnableResponse::class.java)
  }

  override fun usergroupsList(req: UsergroupsListRequest): UsergroupsListResponse {
    val form = FormBody.Builder()
    setIfNotNull("include_disabled", req.isIncludeDisabled, form)
    setIfNotNull("include_count", req.isIncludeCount, form)
    setIfNotNull("include_users", req.isIncludeUsers, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_LIST, req.tokenOrDefault, UsergroupsListResponse::class.java)
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
    return doPostFormWithToken(form, Methods.USERGROUPS_UPDATE, req.tokenOrDefault, UsergroupsUpdateResponse::class.java)
  }

  override fun usergroupUsersList(req: UsergroupUsersListRequest): UsergroupUsersListResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    setIfNotNull("include_disabled", req.isIncludeDisabled, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_USERS_LIST, req.tokenOrDefault, UsergroupUsersListResponse::class.java)
  }

  override fun usergroupUsersUpdate(req: UsergroupUsersUpdateRequest): UsergroupUsersUpdateResponse {
    val form = FormBody.Builder()
    setIfNotNull("usergroup", req.usergroup, form)
    if (req.users != null) {
      setIfNotNull("users", req.users.joinToString(","), form)
    }
    setIfNotNull("include_count", req.isIncludeCount, form)
    return doPostFormWithToken(form, Methods.USERGROUPS_USERS_UPDATE, req.tokenOrDefault, UsergroupUsersUpdateResponse::class.java)
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
        typeValues.add(type.value)
      }
      setIfNotNull("types", typeValues.joinToString(","), form)
    }
    return doPostFormWithToken(form, Methods.USERS_CONVERSATIONS, req.tokenOrDefault, UsersConversationsResponse::class.java)
  }

  override fun usersDeletePhoto(req: UsersDeletePhotoRequest): UsersDeletePhotoResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.USERS_DELETE_PHOTO, req.tokenOrDefault, UsersDeletePhotoResponse::class.java)
  }

  override fun usersGetPresence(req: UsersGetPresenceRequest): UsersGetPresenceResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    return doPostFormWithToken(form, Methods.USERS_GET_PRESENCE, req.tokenOrDefault, UsersGetPresenceResponse::class.java)
  }

  override fun usersIdentity(req: UsersIdentityRequest): UsersIdentityResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.USERS_IDENTITY, req.tokenOrDefault, UsersIdentityResponse::class.java)
  }

  override fun usersInfo(req: UsersInfoRequest): UsersInfoResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    return doPostFormWithToken(form, Methods.USERS_INFO, req.tokenOrDefault, UsersInfoResponse::class.java)
  }

  override fun usersList(req: UsersListRequest): UsersListResponse {
    val form = FormBody.Builder()
    setIfNotNull("cursor", req.cursor, form)
    setIfNotNull("limit", req.limit, form)
    setIfNotNull("include_locale", req.isIncludeLocale, form)
    setIfNotNull("presence", req.isPresence, form)
    return doPostFormWithToken(form, Methods.USERS_LIST, req.tokenOrDefault, UsersListResponse::class.java)
  }

  override fun usersLookupByEmail(req: UsersLookupByEmailRequest): UsersLookupByEmailResponse {
    val form = FormBody.Builder()
    setIfNotNull("email", req.email, form)
    return doPostFormWithToken(form, Methods.USERS_LOOKUP_BY_EMAIL, req.tokenOrDefault, UsersLookupByEmailResponse::class.java)
  }

  override fun usersSetActive(req: UsersSetActiveRequest): UsersSetActiveResponse {
    val form = FormBody.Builder()
    return doPostFormWithToken(form, Methods.USERS_SET_ACTIVE, req.tokenOrDefault, UsersSetActiveResponse::class.java)
  }

  override fun usersSetPhoto(req: UsersSetPhotoRequest): UsersSetPhotoResponse {
    val form = MultipartBody.Builder()
    val image = RequestBody.create(MediaType.parse("image/*"), req.image)
    form.addFormDataPart("image", "image", image)
    setIfNotNull("crop_x", req.cropX, form)
    setIfNotNull("crop_y", req.cropY, form)
    setIfNotNull("crop_w", req.cropW, form)
    return doPostMultipart(form, Methods.USERS_SET_PHOTO, req.tokenOrDefault, UsersSetPhotoResponse::class.java)
  }

  override fun usersSetPresence(req: UsersSetPresenceRequest): UsersSetPresenceResponse {
    val form = FormBody.Builder()
    setIfNotNull("presence", req.presence, form)
    return doPostFormWithToken(form, Methods.USERS_SET_PRESENCE, req.tokenOrDefault, UsersSetPresenceResponse::class.java)
  }

  override fun usersProfileGet(req: UsersProfileGetRequest): UsersProfileGetResponse {
    val form = FormBody.Builder()
    setIfNotNull("user", req.user, form)
    setIfNotNull("include_labels", req.isIncludeLabels, form)
    return doPostFormWithToken(form, Methods.USERS_PROFILE_GET, req.tokenOrDefault, UsersProfileGetResponse::class.java)
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
    return doPostFormWithToken(form, Methods.USERS_PROFILE_SET, req.tokenOrDefault, UsersProfileSetResponse::class.java)
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