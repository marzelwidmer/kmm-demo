package ch.keepcalm.kmm.androidApp.components.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.FIRST_SCREEN
import ch.keepcalm.kmm.androidApp.components.navigation.Destinations.SECOND_SCREEN

@Composable
fun FirstScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Screen\n" +
                    "Click me to go to Second Screen",
            color = Color.Blue,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.padding(24.dp).clickable(onClick = {
                // this will navigate to second screen
                navController.navigate(FIRST_SCREEN)
            })
        )
        Button(onClick = { navController.navigate(SECOND_SCREEN) }) {
            Text("Go to Second Screen")
        }
    }
}