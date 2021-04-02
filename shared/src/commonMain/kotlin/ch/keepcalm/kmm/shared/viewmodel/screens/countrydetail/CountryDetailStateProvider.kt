package ch.keepcalm.kmm.shared.viewmodel.screens.countrydetail

import ch.keepcalm.kmm.shared.viewmodel.StateProvider

fun StateProvider.getCountryDetailState(country : String) : CountryDetailState {

    // the state gets initialized with "initState":
    //      WHEN this function is called for the first time
    //          OR if the "reinitWhen" condition is true
    // after initialization, the "callOnInit" code gets called
    return stateManager.getScreen(
        initState = { CountryDetailState(countryName = country, isLoading = true) },
        callOnInit = { events.loadCountryDetailData(country) },
        reinitWhen = { country != it.countryName }
    )

}