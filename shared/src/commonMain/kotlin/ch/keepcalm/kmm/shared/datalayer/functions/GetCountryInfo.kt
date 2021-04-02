package ch.keepcalm.kmm.shared.datalayer.functions

import ch.keepcalm.kmm.shared.datalayer.Repository
import ch.keepcalm.kmm.shared.datalayer.sources.webservices.apis.fetchCountryExtraData
import ch.keepcalm.kmm.shared.viewmodel.screens.countrydetail.CountryInfo

suspend fun Repository.getCountryInfo(country: String): CountryInfo {

    if (!Repository.countryExtraData.containsKey(country)) {
        webservices.fetchCountryExtraData(country)?.apply {
            Repository.countryExtraData[country] = data
        }
    }

    return CountryInfo(Repository.countriesList.first{it.name==country}, Repository.countryExtraData[country])

}