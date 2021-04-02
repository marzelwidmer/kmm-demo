package ch.keepcalm.kmm.shared.viewmodel.screens.countrydetail

import ch.keepcalm.kmm.shared.viewmodel.Events


/********** INTERNAL event function, used by the StateProvider **********/

internal fun Events.loadCountryDetailData(country: String) {
    // launch a coroutine, as "updateCountryDetail" is a suspend function
    launchCoroutine {
        stateReducers.updateCountryDetail(country)
    }
}