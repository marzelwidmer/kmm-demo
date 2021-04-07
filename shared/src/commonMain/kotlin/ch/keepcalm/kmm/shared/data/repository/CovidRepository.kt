package ch.keepcalm.kmm.shared.data.repository

import ch.keepcalm.kmm.shared.data.remote.CovidApi
import ch.keepcalm.kmm.shared.domain.entities.Country
import ch.keepcalm.kmm.shared.domain.entities.Covid
import ch.keepcalm.kmm.shared.getLogger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CovidRepository  : KoinComponent {
    private val covidApi: CovidApi by inject()
    private val logger = getLogger()

    @Throws(Exception::class)
    suspend fun getCH(): Covid{
        logger.i(tag = "---------> Covid Repo", message = "get country call")
        return Covid(country = covidApi.fetchCH().country)
    }

    @Throws(Exception::class)
    suspend fun fetchAll(): List<Country> {
        logger.i(tag = "---------> Covid Repo", message = "get all country")
        return covidApi.fetchAll().map {
            Country(it)
        }
    }
}