package ch.keepcalm.kmm.shared.data.remote.model

import kotlinx.serialization.*

@Serializable
data class CovidDto(
    @SerialName("subregions") val countries: Array<String>,
    @SerialName("country") val country: String
)