package ch.keepcalm.kmm.shared.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CovidDto(
    @SerialName("subregions") val countries: Array<String>,
    @SerialName("country") val country: String
)