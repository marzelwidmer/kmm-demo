package ch.keepcalm.kmm.shared.datalayer.functions

import ch.keepcalm.kmm.shared.datalayer.Repository
import ch.keepcalm.kmm.shared.datalayer.sources.webservices.apis.fetchCountriesList
import ch.keepcalm.kmm.shared.viewmodel.screens.countrieslist.CountriesListItem
import ch.keepcalm.kmm.shared.viewmodel.debugLogger


suspend fun Repository.getCountriesListData(): List<CountriesListItem> {

    if (Repository.countriesList.isEmpty()) {
        webservices.fetchCountriesList()?.apply {
            Repository.countriesList = data.sortedByDescending { it.firstDosesPercentageFloat }
            if (error!=null) {
                debugLogger.log ("ERROR MESSAGE: $error")
            }
        }
    }

    return Repository.countriesList.map { elem -> CountriesListItem(_data = elem) }.toList()

}