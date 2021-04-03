package ch.keepcalm.kmm.shared.domain.model

data class Covid (
    val country: String,
    val subregions: List<String> = listOf(),
)

