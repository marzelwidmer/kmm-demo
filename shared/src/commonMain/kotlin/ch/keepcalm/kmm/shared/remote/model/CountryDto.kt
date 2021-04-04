package ch.keepcalm.kmm.shared.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val names: List<String>
)