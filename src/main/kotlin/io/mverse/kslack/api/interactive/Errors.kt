package io.mverse.kslack.api.interactive

data class Errors(val errors: List<Error> = listOf())

data class Error(
    /**
     * The name of the field that had the error
     */
    val name: String,

    /**
     * The error message
     */
    val error: String)