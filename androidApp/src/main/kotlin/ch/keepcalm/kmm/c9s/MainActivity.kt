package ch.keepcalm.kmm.c9s

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ch.keepcalm.kmm.c9s.screens.MainLayout
import ch.keepcalm.kmm.c9s.screens.covid.CovidViewModel
import ch.keepcalm.kmm.c9s.themes.C9STheme
import ch.keepcalm.kmm.shared.Greeting
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val covidViewModel: CovidViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//                Greeting(greet())
            MainLayout(covidViewModel)
        }
    }
}


fun greet(): String {
    return Greeting().greeting()
}

@Composable
fun Greeting(name: String) {
    Text(text = name)
}

@Preview(showBackground = true, showSystemUi = true/*,backgroundColor = 0xFFFFFFFF*/)
@Composable
fun DefaultPreview() {
    C9STheme {
        Greeting(greet())
    }
}

