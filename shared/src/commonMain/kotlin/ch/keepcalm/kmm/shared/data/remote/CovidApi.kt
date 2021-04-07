package ch.keepcalm.kmm.shared.data.remote

import ch.keepcalm.kmm.shared.data.remote.model.CovidDto
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent


class CovidApi(private val client: HttpClient, private val baseUrl: String = "https://disease.sh/v3/covid-19/apple/countries") : KoinComponent {
    suspend fun fetchCH() = client.get<CovidDto>("$baseUrl/ch")
    suspend fun fetchAll() = client.get<List<String>>(baseUrl)
}

