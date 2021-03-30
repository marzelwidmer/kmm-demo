package ch.keepcalm.kmm.androidApp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.FIRST_SCREEN
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.SECOND_SCREEN
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.THIRD_SCREEN
import ch.keepcalm.kmm.androidApp.components.screen.FirstScreen
import ch.keepcalm.kmm.androidApp.components.screen.SecondScreen
import ch.keepcalm.kmm.androidApp.components.screen.ThirdScreen

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = FIRST_SCREEN
    ) {
        composable(FIRST_SCREEN) {
            FirstScreen(navController = navController)
        }
        composable(SECOND_SCREEN) {
            SecondScreen(navController = navController)
        }
        composable(THIRD_SCREEN) {
            ThirdScreen(navController = navController)
        }
    }
}

