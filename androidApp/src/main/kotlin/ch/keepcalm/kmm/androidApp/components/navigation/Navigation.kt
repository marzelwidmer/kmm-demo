package ch.keepcalm.kmm.androidApp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.EDIT_SCREEN
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.FAVORITE_SCREEN
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.NOTIFICATION_SCREEN
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.PROFILE_SCREEN
import ch.keepcalm.kmm.androidApp.components.screen.EditScreen
import ch.keepcalm.kmm.androidApp.components.screen.FavoriteScreen
import ch.keepcalm.kmm.androidApp.components.screen.NotificationScreen
import ch.keepcalm.kmm.androidApp.components.screen.ProfileScreen

@Composable
fun Navigation(navController: NavHostController, topTitleBar: MutableState<String>){
    NavHost(navController =navController, startDestination = PROFILE_SCREEN) {
        composable(PROFILE_SCREEN){
            ProfileScreen()
            topTitleBar.value = "Profile"
        }
        composable(EDIT_SCREEN){
            EditScreen()
            topTitleBar.value = "Edit"
        }
        composable(FAVORITE_SCREEN){
            FavoriteScreen()
            topTitleBar.value = "Favorite"
        }
        composable(NOTIFICATION_SCREEN){
            NotificationScreen()
            topTitleBar.value = "Notification"
        }
    }
}