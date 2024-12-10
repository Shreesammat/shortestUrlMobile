import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.shortest1.network.NetworkService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var inputState by remember { mutableStateOf(TextFieldValue("")) }
    var outputState by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope() // To run async operations

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Home Screen")})
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputState,
                onValueChange = { inputState = it },
                label = { Text("Enter URL to shorten") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Send the POST request and update the state
                    coroutineScope.launch {
                        try {
                            // Send the URL to the backend
                            val shortenedUrl = NetworkService.shortenUrl(inputState.text)
                            // Display the shortened URL
                            outputState = "$shortenedUrl"
                        } catch (e: Exception) {
                            // Handle any errors from the network request
                            outputState = "Error: ${e.message}"
                        }
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Submit")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                    .padding(10.dp)
            ) {
                Text(outputState, style = TextStyle(color = Color.White))
            }
        }
    }
}
