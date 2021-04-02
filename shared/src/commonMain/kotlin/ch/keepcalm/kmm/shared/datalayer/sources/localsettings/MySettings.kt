package ch.keepcalm.kmm.shared.datalayer.sources.localsettings

import ch.keepcalm.kmm.shared.viewmodel.screens.countrieslist.MenuItem
import com.russhwolf.settings.Settings

class MySettings (s : Settings) : SettingsClient(s) {

    // here we put all the values we want to save in MultiplatformSettings,
    // we can custom our types, by using Kotlin's delegated properties: https://kotlinlang.org/docs/delegated-properties.html
    // we wrote our types definition in the SettingClient class

    var selectedMenuItem by MenuItemType(MenuItem.ALL)
    var favoriteCountries by TrueMapType()
    //var selectedString by StringType("mytext")

}