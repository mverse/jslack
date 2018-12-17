//package io.mverse.kslack.api.rtm
//
//import java.io.Closeable
//import java.io.IOException
//import java.net.URI
//import java.net.URISyntaxException
//import java.util.*
//
//@ClientEndpoint
//
//class RTMClient
//constructor(wssUrl: String?) : Closeable {
//
//  private val wssUri: URI
//  private var currentSession: Session? = null
//
//  private val messageHandlers = ArrayList<RTMMessageHandler>()
//  private val errorHandlers = ArrayList<RTMErrorHandler>()
//  private val closeHandlers = ArrayList<RTMCloseHandler>()
//
//  init {
//    if (wssUrl == null) {
//      throw IllegalArgumentException("The wss URL to start Real Time Messaging API is absent.")
//    }
//    this.wssUri = URI(wssUrl)
//  }
//
//
//  fun connect() {
//    val container = ContainerProvider.getWebSocketContainer()
//    container.connectToServer(this, wssUri)
//    log.debug("client connected to the server: {}", wssUri)
//  }
//
//
//  fun disconnect() {
//    if (currentSession != null) {
//      currentSession!!.close(CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, RTMClient::class.java.canonicalName + " did it"))
//    }
//  }
//
//
//  override fun close() {
//    disconnect()
//  }
//
//  @OnOpen
//  fun onOpen(session: Session) {
//    log.debug("session opened: {}", session.getId())
//    this.currentSession = session
//  }
//
//  @OnClose
//  fun onClose(session: Session, reason: CloseReason) {
//    log.debug("session closed: {}, reason: {}", session.getId(), reason.getReasonPhrase())
//    this.currentSession = null
//
//    closeHandlers.forEach { closeHandler -> closeHandler.handle(reason) }
//  }
//
//  @OnError
//  fun onError(session: Session, reason: Throwable) {
//    log.error("session errored, exception is below", reason)
//    this.currentSession = null
//
//    errorHandlers.forEach { errorHandler -> errorHandler.handle(reason) }
//  }
//
//  @OnMessage
//  fun onMessage(message: String) {
//    log.debug("message: {}", message)
//    messageHandlers.forEach { messageHandler -> messageHandler.handle(message) }
//  }
//
//  fun addMessageHandler(messageHandler: RTMMessageHandler) {
//    messageHandlers.add(messageHandler)
//  }
//
//  fun removeMessageHandler(messageHandler: RTMMessageHandler) {
//    messageHandlers.remove(messageHandler)
//  }
//
//  fun addErrorHandler(errorHandler: RTMErrorHandler) {
//    errorHandlers.add(errorHandler)
//  }
//
//  fun removeErrorHandler(errorHandler: RTMErrorHandler) {
//    errorHandlers.remove(errorHandler)
//  }
//
//  fun addCloseHandler(closeHandler: RTMCloseHandler) {
//    closeHandlers.add(closeHandler)
//  }
//
//  fun removeCloseHandler(closeHandler: RTMCloseHandler) {
//    closeHandlers.remove(closeHandler)
//  }
//
//  fun sendMessage(message: String) {
//    this.currentSession!!.getAsyncRemote().sendText(message)
//  }
//}
