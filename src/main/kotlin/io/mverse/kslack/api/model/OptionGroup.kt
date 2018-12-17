package io.mverse.kslack.api.model

data class OptionGroup(
    val label: String? = null,
    val options: List<OptionGroup>? = null)
