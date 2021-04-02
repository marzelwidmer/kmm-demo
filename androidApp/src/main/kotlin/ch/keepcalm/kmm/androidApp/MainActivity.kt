package ch.keepcalm.kmm.androidApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ch.keepcalm.kmm.androidApp.styling.KMMDemoTheme
import ch.keepcalm.kmm.shared.Greeting


class MainActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMMDemoTheme() {
                Navigation(appViewModel.coreModel)
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