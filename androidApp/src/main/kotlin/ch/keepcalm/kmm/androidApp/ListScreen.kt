package ch.keepcalm.kmm.androidApp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ListScreenPreview() {
    ListScreen()
}

@Composable
fun ListScreen() {

    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {

        /**set TopApp And Bottom Bar*/
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "D-KMP sample", fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                })
            },
            content = { paddingValues ->
                LazyColumn(contentPadding = paddingValues) {
                    stickyHeader {
                        ListHeader()
                    }
                    items(items = listOf("Foo", "Bar"), itemContent = { item ->
                        ListRow(item = item)
                    })
                }
            },
            bottomBar = {
            }
        )
    }
}


@Composable
fun ListHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.LightGray)
            .padding(start = 10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row { Text(text = "name", fontSize = 16.sp) }
        }
    }
}
@Composable
fun ListRow(item: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(start = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier
            .weight(1f)
            .padding(end = 10.dp)) {
            Text(text = item, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
        }
    }
    Divider()
}


