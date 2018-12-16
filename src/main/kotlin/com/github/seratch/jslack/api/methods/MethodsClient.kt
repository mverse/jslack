package com.github.seratch.jslack.api.methods

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
import java.io.IOException

/**
 * API Methods.
 * https://api.slack.com/methods
 */
interface MethodsClient {

  fun setEndpointUrlPrefix(endpointUrlPrefix: String)

  // ------------------------------
  // api
  // ------------------------------


  fun apiTest(req: ApiTestRequest): ApiTestResponse

  // ------------------------------
  // apps.permissions
  // ------------------------------


  fun appsPermissionsInfo(req: AppsPermissionsInfoRequest): AppsPermissionsInfoResponse


  fun appsPermissionsRequest(req: AppsPermissionsRequestRequest): AppsPermissionsRequestResponse

  // ------------------------------
  // auth
  // ------------------------------


  fun authRevoke(req: AuthRevokeRequest): AuthRevokeResponse


  fun authTest(req: AuthTestRequest): AuthTestResponse

  // ------------------------------
  // bots
  // ------------------------------


  fun botsInfo(req: BotsInfoRequest): BotsInfoResponse

  // ------------------------------
  // channels
  // ------------------------------


  fun channelsArchive(req: ChannelsArchiveRequest): ChannelsArchiveResponse


  fun channelsCreate(req: ChannelsCreateRequest): ChannelsCreateResponse


  fun channelsHistory(req: ChannelsHistoryRequest): ChannelsHistoryResponse


  fun channelsReplies(req: ChannelsRepliesRequest): ChannelsRepliesResponse


  fun channelsInfo(req: ChannelsInfoRequest): ChannelsInfoResponse


  fun channelsList(req: ChannelsListRequest): ChannelsListResponse


  fun channelsInvite(req: ChannelsInviteRequest): ChannelsInviteResponse


  fun channelsJoin(req: ChannelsJoinRequest): ChannelsJoinResponse


  fun channelsKick(req: ChannelsKickRequest): ChannelsKickResponse


  fun channelsLeave(req: ChannelsLeaveRequest): ChannelsLeaveResponse


  fun channelsMark(req: ChannelsMarkRequest): ChannelsMarkResponse


  fun channelsRename(req: ChannelsRenameRequest): ChannelsRenameResponse


  fun channelsSetPurpose(req: ChannelsSetPurposeRequest): ChannelsSetPurposeResponse


  fun channelsSetTopic(req: ChannelsSetTopicRequest): ChannelsSetTopicResponse


  fun channelsUnarchive(req: ChannelsUnarchiveRequest): ChannelsUnarchiveResponse

  // ------------------------------
  // chat
  // ------------------------------


  fun chatGetPermalink(req: ChatGetPermalinkRequest): ChatGetPermalinkResponse


  fun chatDelete(req: ChatDeleteRequest): ChatDeleteResponse


  fun chatMeMessage(req: ChatMeMessageRequest): ChatMeMessageResponse


  fun chatPostEphemeral(req: ChatPostEphemeralRequest): ChatPostEphemeralResponse


  fun chatPostMessage(req: ChatPostMessageRequest): ChatPostMessageResponse


  fun chatUpdate(req: ChatUpdateRequest): ChatUpdateResponse


  fun chatUnfurl(req: ChatUnfurlRequest): ChatUnfurlResponse

  // ------------------------------
  // conversations
  // ------------------------------


  fun conversationsArchive(req: ConversationsArchiveRequest): ConversationsArchiveResponse


  fun conversationsClose(req: ConversationsCloseRequest): ConversationsCloseResponse


  fun conversationsCreate(req: ConversationsCreateRequest): ConversationsCreateResponse


  fun conversationsHistory(req: ConversationsHistoryRequest): ConversationsHistoryResponse


  fun conversationsInfo(req: ConversationsInfoRequest): ConversationsInfoResponse


  fun conversationsInvite(req: ConversationsInviteRequest): ConversationsInviteResponse


  fun conversationsJoin(req: ConversationsJoinRequest): ConversationsJoinResponse


  fun conversationsKick(req: ConversationsKickRequest): ConversationsKickResponse


  fun conversationsLeave(req: ConversationsLeaveRequest): ConversationsLeaveResponse


  fun conversationsList(req: ConversationsListRequest): ConversationsListResponse


  fun conversationsMembers(req: ConversationsMembersRequest): ConversationsMembersResponse


  fun conversationsOpen(req: ConversationsOpenRequest): ConversationsOpenResponse


  fun conversationsRename(req: ConversationsRenameRequest): ConversationsRenameResponse


  fun conversationsReplies(req: ConversationsRepliesRequest): ConversationsRepliesResponse


  fun conversationsSetPurpose(req: ConversationsSetPurposeRequest): ConversationsSetPurposeResponse


  fun conversationsSetTopic(req: ConversationsSetTopicRequest): ConversationsSetTopicResponse


  fun conversationsUnarchive(req: ConversationsUnarchiveRequest): ConversationsUnarchiveResponse

  // ------------------------------
  // dialog
  // ------------------------------


  fun dialogOpen(req: DialogOpenRequest): DialogOpenResponse

  // ------------------------------
  // dnd
  // ------------------------------


  fun dndEndDnd(req: DndEndDndRequest): DndEndDndResponse


  fun dndEndSnooze(req: DndEndSnoozeRequest): DndEndSnoozeResponse


  fun dndInfo(req: DndInfoRequest): DndInfoResponse


  fun dndSetSnooze(req: DndSetSnoozeRequest): DndSetSnoozeResponse


  fun dndTeamInfo(req: DndTeamInfoRequest): DndTeamInfoResponse

  // ------------------------------
  // emoji
  // ------------------------------


  fun emojiList(req: EmojiListRequest): EmojiListResponse

  // ------------------------------
  // files
  // ------------------------------


  fun filesDelete(req: FilesDeleteRequest): FilesDeleteResponse


  fun filesInfo(req: FilesInfoRequest): FilesInfoResponse


  fun filesList(req: FilesListRequest): FilesListResponse


  fun filesRevokePublicURL(req: FilesRevokePublicURLRequest): FilesRevokePublicURLResponse


  fun filesSharedPublicURL(req: FilesSharedPublicURLRequest): FilesSharedPublicURLResponse


  fun filesUpload(req: FilesUploadRequest): FilesUploadResponse

  // ------------------------------
  // files.comments
  // ------------------------------


  fun filesCommentsAdd(req: FilesCommentsAddRequest): FilesCommentsAddResponse


  fun filesCommentsDelete(req: FilesCommentsDeleteRequest): FilesCommentsDeleteResponse


  fun filesCommentEdit(req: FilesCommentsEditRequest): FilesCommentsEditResponse

  // ------------------------------
  // groups
  // ------------------------------


  fun groupsArchive(req: GroupsArchiveRequest): GroupsArchiveResponse


  fun groupsClose(req: GroupsCloseRequest): GroupsCloseResponse


  fun groupsCreateChild(req: GroupsCreateChildRequest): GroupsCreateChildResponse


  fun groupsCreate(req: GroupsCreateRequest): GroupsCreateResponse


  fun groupsHistory(req: GroupsHistoryRequest): GroupsHistoryResponse


  fun groupsInfo(req: GroupsInfoRequest): GroupsInfoResponse


  fun groupsInvite(req: GroupsInviteRequest): GroupsInviteResponse


  fun groupsKick(req: GroupsKickRequest): GroupsKickResponse


  fun groupsLeave(req: GroupsLeaveRequest): GroupsLeaveResponse


  fun groupsList(req: GroupsListRequest): GroupsListResponse


  fun groupsMark(req: GroupsMarkRequest): GroupsMarkResponse


  fun groupsOpen(req: GroupsOpenRequest): GroupsOpenResponse


  fun groupsRename(req: GroupsRenameRequest): GroupsRenameResponse


  fun groupsSetPurpose(req: GroupsSetPurposeRequest): GroupsSetPurposeResponse


  fun groupsSetTopic(req: GroupsSetTopicRequest): GroupsSetTopicResponse


  fun groupsUnarchive(req: GroupsUnarchiveRequest): GroupsUnarchiveResponse


  fun groupsReplies(req: GroupsRepliesRequest): GroupsRepliesResponse

  // ------------------------------
  // im
  // ------------------------------


  fun imClose(req: ImCloseRequest): ImCloseResponse


  fun imHistory(req: ImHistoryRequest): ImHistoryResponse


  fun imList(req: ImListRequest): ImListResponse


  fun imMark(req: ImMarkRequest): ImMarkResponse


  fun imOpen(req: ImOpenRequest): ImOpenResponse


  fun imReplies(req: ImRepliesRequest): ImRepliesResponse

  // ------------------------------
  // migration
  // ------------------------------


  fun migrationExchange(req: MigrationExchangeRequest): MigrationExchangeResponse

  // ------------------------------
  // mpim
  // ------------------------------


  fun mpimClose(req: MpimCloseRequest): MpimCloseResponse


  fun mpimHistory(req: MpimHistoryRequest): MpimHistoryResponse


  fun mpimList(req: MpimListRequest): MpimListResponse


  fun mpimReplies(req: MpimRepliesRequest): MpimRepliesResponse


  fun mpimMark(req: MpimMarkRequest): MpimMarkResponse


  fun mpimOpen(req: MpimOpenRequest): MpimOpenResponse

  // ------------------------------
  // oauth
  // ------------------------------


  fun oauthAccess(req: OAuthAccessRequest): OAuthAccessResponse


  fun oauthToken(req: OAuthTokenRequest): OAuthTokenResponse

  // ------------------------------
  // pins
  // ------------------------------


  fun pinsAdd(req: PinsAddRequest): PinsAddResponse


  fun pinsList(req: PinsListRequest): PinsListResponse


  fun pinsRemove(req: PinsRemoveRequest): PinsRemoveResponse

  // ------------------------------
  // reactions
  // ------------------------------


  fun reactionsAdd(req: ReactionsAddRequest): ReactionsAddResponse


  fun reactionsGet(req: ReactionsGetRequest): ReactionsGetResponse


  fun reactionsList(req: ReactionsListRequest): ReactionsListResponse


  fun reactionsRemove(req: ReactionsRemoveRequest): ReactionsRemoveResponse

  // ------------------------------
  // reminders
  // ------------------------------


  fun remindersAdd(req: RemindersAddRequest): RemindersAddResponse


  fun remindersComplete(req: RemindersCompleteRequest): RemindersCompleteResponse


  fun remindersDelete(req: RemindersDeleteRequest): RemindersDeleteResponse


  fun remindersInfo(req: RemindersInfoRequest): RemindersInfoResponse


  fun remindersList(req: RemindersListRequest): RemindersListResponse

  // ------------------------------
  // rtm
  // ------------------------------


  fun rtmConnect(req: RTMConnectRequest): RTMConnectResponse


  fun rtmStart(req: RTMStartRequest): RTMStartResponse

  // ------------------------------
  // search
  // ------------------------------


  fun searchAll(req: SearchAllRequest): SearchAllResponse


  fun searchMessages(req: SearchMessagesRequest): SearchMessagesResponse


  fun searchFiles(req: SearchFilesRequest): SearchFilesResponse

  // ------------------------------
  // stars
  // ------------------------------


  fun starsAdd(req: StarsAddRequest): StarsAddResponse


  fun starsList(req: StarsListRequest): StarsListResponse


  fun starsRemove(req: StarsRemoveRequest): StarsRemoveResponse

  // ------------------------------
  // team
  // ------------------------------


  fun teamAccessLogs(req: TeamAccessLogsRequest): TeamAccessLogsResponse


  fun teamBillableInfo(req: TeamBillableInfoRequest): TeamBillableInfoResponse


  fun teamInfo(req: TeamInfoRequest): TeamInfoResponse


  fun teamIntegrationLogs(req: TeamIntegrationLogsRequest): TeamIntegrationLogsResponse


  fun teamProfileGet(req: TeamProfileGetRequest): TeamProfileGetResponse

  // ------------------------------
  // usergroups
  // ------------------------------


  fun usergroupsCreate(req: UsergroupsCreateRequest): UsergroupsCreateResponse


  fun usergroupsDisable(req: UsergroupsDisableRequest): UsergroupsDisableResponse


  fun usergroupsEnable(req: UsergroupsEnableRequest): UsergroupsEnableResponse


  fun usergroupsList(req: UsergroupsListRequest): UsergroupsListResponse


  fun usergroupsUpdate(req: UsergroupsUpdateRequest): UsergroupsUpdateResponse


  fun usergroupUsersList(req: UsergroupUsersListRequest): UsergroupUsersListResponse


  fun usergroupUsersUpdate(req: UsergroupUsersUpdateRequest): UsergroupUsersUpdateResponse

  // ------------------------------
  // users
  // ------------------------------


  fun usersConversations(req: UsersConversationsRequest): UsersConversationsResponse


  fun usersDeletePhoto(req: UsersDeletePhotoRequest): UsersDeletePhotoResponse


  fun usersGetPresence(req: UsersGetPresenceRequest): UsersGetPresenceResponse


  fun usersIdentity(req: UsersIdentityRequest): UsersIdentityResponse


  fun usersInfo(req: UsersInfoRequest): UsersInfoResponse


  fun usersList(req: UsersListRequest): UsersListResponse


  fun usersLookupByEmail(req: UsersLookupByEmailRequest): UsersLookupByEmailResponse


  fun usersSetActive(req: UsersSetActiveRequest): UsersSetActiveResponse


  fun usersSetPhoto(req: UsersSetPhotoRequest): UsersSetPhotoResponse


  fun usersSetPresence(req: UsersSetPresenceRequest): UsersSetPresenceResponse

  // ------------------------------
  // users.profile
  // ------------------------------


  fun usersProfileGet(req: UsersProfileGetRequest): UsersProfileGetResponse


  fun usersProfileSet(req: UsersProfileSetRequest): UsersProfileSetResponse
}
