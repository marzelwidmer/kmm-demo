package ch.keepcalm.kmm.shared.viewmodel.screens.countrieslist

import ch.keepcalm.kmm.shared.datalayer.sources.webservices.apis.CountryListData
import ch.keepcalm.kmm.shared.viewmodel.ScreenState
import ch.keepcalm.kmm.shared.viewmodel.utils.toPercentageString


/********** ScreenState class definition **********/

data class CountriesListState (
    val isLoading: Boolean = false,
    val selectedMenuItem : MenuItem = MenuItem.ALL,
    val countriesListItems : List<CountriesListItem> = emptyList(),
    val favoriteCountries : Map<String,Boolean> = emptyMap(),
): ScreenState


/********** property classes definition **********/


enum class MenuItem { ALL, FAVORITES }

class CountriesListItem (
    _data : CountryListData,
) {
    // in the ViewModel classes, our computed properties only do UI-formatting operations
    // (the arithmetical operations, such as calculating a percentage, should happen in the DataLayer classes)
    val name = _data.name
    val firstDosesPerc = _data.firstDosesPercentageFloat.toPercentageString()
    val fullyVaccinatedPerc = _data.fullyVaccinatedPercentageFloat.toPercentageString()
}