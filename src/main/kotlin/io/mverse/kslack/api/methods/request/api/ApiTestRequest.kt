package io.mverse.kslack.api.methods.request.api

data class ApiTestRequest(

    /**
     * example property to return
     */
    val foo: String? = null,

    /**
     * Error response to return
     */
    val error: String? = null)