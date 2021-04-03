package ch.keepcalm.kmm.shared.datasource.network


import ch.keepcalm.kmm.shared.DebugLogger
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.native.concurrent.ThreadLocal


//@Serializable
//data class SubregionsListResult(val subregions: List<Subregion>)
//
//@Serializable
//data class Subregion(val canton: String)

@Serializable
data class CountriesListResponse(
    @SerialName("subregions") val subregions : Array<String>,
    @SerialName("country") val country : String
)



@ThreadLocal
object CovidApi {

    val debugLogger by lazy { DebugLogger("KMM-DEMO") }

//    private val BASE_URL = "https://corona.lmao.ninja/v2/countries"
    private val BASE_URL = "https://disease.sh/v3/covid-19/apple/countries/ch"

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json { ignoreUnknownKeys = true })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
    }

    suspend fun fetchCountriesList(): CountriesListResponse {
        debugLogger.log("call service -------->>>>>>>>>>>>")
        return client.get(BASE_URL)
    }

}
