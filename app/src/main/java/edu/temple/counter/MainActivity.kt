package edu.temple.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.temple.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var count: Int by rememberSaveable { mutableStateOf(0) }

        Button(onClick = { count += 1 }) {
            Text(text = "+")
        }

        Text(
            text = count.toString(),
            fontSize = 192.sp,
        )

        Button(onClick = { count -= 1 }) {
            Text(text = "-")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        Counter()
    }
}