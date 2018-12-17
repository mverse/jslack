package io.mverse.kslack.api.methods

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
