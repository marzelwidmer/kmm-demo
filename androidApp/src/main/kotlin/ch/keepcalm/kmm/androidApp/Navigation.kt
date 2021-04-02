package ch.keepcalm.kmm.androidApp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import ch.keepcalm.kmm.androidApp.screens.countrieslist.CountriesListScreen
import ch.keepcalm.kmm.androidApp.screens.countrydetail.CountryDetailScreen
import ch.keepcalm.kmm.shared.viewmodel.CoreViewModel
import ch.keepcalm.kmm.shared.viewmodel.screens.countrieslist.getCountriesListState
import ch.keepcalm.kmm.shared.viewmodel.screens.countrydetail.getCountryDetailState

@Composable
fun Navigation(model: CoreViewModel) {

    val events = model.events
    val appState by model.stateFlow.collectAsState()
    Log.d("Navigation","recomposition Index: "+appState.recompositionIndex.toString())
    val stateProvider = appState.getStateProvider(model)


    val navController = rememberNavController()

    NavHost(navController, startDestination = "countrieslist") {
        composable("countrieslist") {
            CountriesListScreen(
                countriesListState = stateProvider.getCountriesListState(),
                events = events,
                onListItemClick = { navController.navigate("country/$it") },
            )
        }
        composable("country/{item}") { backStackEntry ->
            val item = backStackEntry.arguments?.getString("item")!!
            CountryDetailScreen(
                countryDetailState = stateProvider.getCountryDetailState(item)
            )
        }
    }

}