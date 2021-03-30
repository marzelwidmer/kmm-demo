package ch.keepcalm.kmm.androidApp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import ch.keepcalm.kmm.androidApp.components.navigation.Navigation
import ch.keepcalm.kmm.androidApp.components.screen.Screen
import ch.keepcalm.kmm.androidApp.components.theme.BottomNavigationBarSTheme
import ch.keepcalm.kmm.shared.Greeting

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "KMM Demo"

        setContent {
//            ComposeNavigation()

            BottomNavigationBarSTheme {

                val navController = rememberNavController()
                val titless = remember { mutableStateOf("Profile") }

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    /**set TopApp And Bottom Bar*/
                    Scaffold(
                        topBar = {
                            TopAppBar(title = { Text(text = titless.value) }, actions = {
                                IconButton(
                                    onClick = {
                                        Toast.makeText(this@MainActivity, "This is Search", Toast.LENGTH_SHORT).show()
                                    }
                                ) {
                                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                                    }
                                }
                            )
                        },
                        bottomBar = {
                            val items = listOf<Screen>(
                                Screen.Profile,
                                Screen.Edit,
                                Screen.Favorite,
                                Screen.Notification)

                            /**set design*/
                            BottomNavigation(backgroundColor = Color.Transparent, elevation = 15.dp, modifier = Modifier.padding(start = 22.dp, end = 22.dp, bottom = 15.dp, top = 10.dp)) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                                items.forEach {
                                    BottomNavigationItem(modifier = Modifier.background(Color.White, shape = RectangleShape), unselectedContentColor = Color.Blue, selectedContentColor = Color.Red,
                                        icon = { Icon(imageVector = it.icon, contentDescription = "Profile") },
                                        selected = currentRoute == it.route,
                                        onClick = {
                                            navController.popBackStack(navController.graph.startDestination, false)
                                            if (currentRoute != it.route) {
                                                navController.navigate(it.route)
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    )
                    {
                        Navigation(navController = navController, topTitleBar = titless)
                    }
                }
            }
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
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun DefaultPreview() {
    BottomNavigationBarSTheme {
        Greeting("Android")
    }
}