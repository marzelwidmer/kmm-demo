package ch.keepcalm.kmm.shared.datasource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CovidDto(

        @SerialName("country")
        val country: String,

        @SerialName("subregions")
        val subregions: List<String> = emptyList()
)