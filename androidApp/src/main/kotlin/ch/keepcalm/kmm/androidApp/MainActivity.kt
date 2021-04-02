package ch.keepcalm.kmm.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ch.keepcalm.kmm.shared.Greeting

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "KMM Demo"

        setContent {
           ListScreen()
        }
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