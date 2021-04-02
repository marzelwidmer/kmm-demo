package ch.keepcalm.kmm.shared.datalayer

import ch.keepcalm.kmm.shared.datalayer.sources.localsettings.MySettings
import com.russhwolf.settings.Settings
import ch.keepcalm.kmm.shared.datalayer.sources.webservices.ApiClient
import ch.keepcalm.kmm.shared.datalayer.sources.webservices.apis.CountryExtraData
import ch.keepcalm.kmm.shared.datalayer.sources.webservices.apis.CountryListData
import kotlin.native.concurrent.ThreadLocal


class Repository (val settings : Settings = Settings()) {

    @ThreadLocal
    companion object Data {
        var countriesList: List<CountryListData> = emptyList()
        var countryExtraData : MutableMap<String, CountryExtraData> = mutableMapOf()
    }

    internal val webservices by lazy { ApiClient() }
    val localSettings by lazy { MySettings(settings) }

}