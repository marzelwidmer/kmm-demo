package ch.keepcalm.kmm.shared.data.remote.model

import kotlinx.serialization.*

@Serializable
data class CountryDto(
    val names: List<String>
)