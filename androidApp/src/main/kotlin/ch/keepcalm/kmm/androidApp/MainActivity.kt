package ch.keepcalm.kmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.keepcalm.kmm.shared.Greeting
import android.widget.TextView

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigation()
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val tv: TextView = findViewById(R.id.text_view)
//        tv.text = greet()
//    }
}




@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            FirstScreen(navController = navController)
        }
        composable("second_screen") {
            SecondScreen(navController = navController)
        }
        composable("third_screen") {
            ThirdScreen(navController = navController)
        }
    }
}
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
                navController.navigate("second_screen")
            })
        )
    }
}
@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen\n" +
                    "Click me to go to Third Screen",
            color = Color.Blue,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.clickable(onClick = {
                // this will navigate to third screen
                navController.navigate("third_screen")
            })
        )
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Third Screen\n" +
                    "Click me to go to First Screen",
            color = Color.Red,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.clickable(onClick = {
                // this will navigate to first screen
                navController.navigate("first_screen")
            })
        )
    }
}

@Composable
fun SimpleComposable() {
    Text(text = "Hello from JetPack Compose Material ")
}

@Preview
@Composable
fun ComposablePreview() {
    SimpleComposable()
}