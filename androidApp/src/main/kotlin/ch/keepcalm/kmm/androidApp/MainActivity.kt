package ch.keepcalm.kmm.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ch.keepcalm.kmm.shared.Greeting
import ch.keepcalm.kmm.shared.datasource.network.CountriesListResponse
import ch.keepcalm.kmm.shared.datasource.repository.CovidRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "KMM Demo"

        setContent {
            var result: CountriesListResponse
            mainScope.launch {
                result = CovidRepository().fetchCountriesList()
                println("----------------------------------------->>>>>>>>>>> ${result.country}")
            }
            ListScreen()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}


fun greet(): String {
    return Greeting().greeting()
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name! ${greet()}")
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun DefaultPreview() {
    Greeting("Android")
}