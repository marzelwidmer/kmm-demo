package ch.keepcalm.kmm.shared.datasource.repository;

import ch.keepcalm.kmm.shared.datasource.network.CountriesListResponse
import ch.keepcalm.kmm.shared.datasource.network.CovidApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope

@ExperimentalCoroutinesApi
class CovidRepository  {
    private val covidApi = CovidApi

    private val coroutineScope: CoroutineScope = MainScope()

//    private val _subregionsListList = MutableStateFlow<List<Subregions>>(emptyList())
//    val subregionsList: StateFlow<List<Subregions>> = _subregionsListList

    suspend fun fetchCountriesList(): CountriesListResponse {
        return covidApi.fetchCountriesList()
    }
}