
package com.example.varzeshroozaneh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.varzeshroozaneh.ui.theme.VarzeshRoozanehTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VarzeshRoozanehTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    WorkoutScreen()
                }
            }
        }
    }
}

@Composable
fun WorkoutScreen() {
    var day by remember { mutableStateOf(1) }
    val baseReps = 10
    val extra = (day - 1) / 7 * 10
    val currentReps = baseReps + extra

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "روز $day", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "شنا سوئدی: $currentReps تکرار")
        Text(text = "شکم: $currentReps تکرار")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { day++ }) {
            Text("تمرین انجام شد")
        }
    }
}
