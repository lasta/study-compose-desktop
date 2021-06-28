import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import client.ElasticsearchClientImpl
import kotlinx.coroutines.runBlocking
import repository.ZipcodeRepositoryImpl
import service.ZipcodeService
import service.ZipcodeServiceImpl

fun main() {
    val service: ZipcodeService = ZipcodeServiceImpl(
        repository = ZipcodeRepositoryImpl(
            client = ElasticsearchClientImpl()
        )
    )

    Window(title = "Find address by Postal Zipcode", size = IntSize(1024, 768)) {

        MaterialTheme {
            var text by remember { mutableStateOf("") }

            Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.onPreviewKeyEvent {
                        false
                    }
                )
                Text(text)
                if (text.isNotEmpty()) {
                    val response = runBlocking {
                        service.completeByZipcode(zipcodeFragment = text)
                    }
                    response.forEach { document ->
                        Text("${document.zipcode}: ${document.address} (${document.ruby})")
                    }
                }
            }
        }
    }
}
