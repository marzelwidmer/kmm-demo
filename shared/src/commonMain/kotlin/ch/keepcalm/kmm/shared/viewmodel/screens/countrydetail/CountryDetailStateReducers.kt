package ch.keepcalm.kmm.shared.viewmodel.screens.countrydetail

import ch.keepcalm.kmm.shared.datalayer.functions.getCountryInfo
import ch.keepcalm.kmm.shared.viewmodel.StateReducers

suspend fun StateReducers.updateCountryDetail(country: String) {
    // update CountryDetailState, after retrieving it from the Repository
    val listItemData = dataRepository.getCountryInfo(country)
    stateManager.updateScreen(CountryDetailState::class) {
        it.copy(countryInfo = listItemData, isLoading = false)
    }
}