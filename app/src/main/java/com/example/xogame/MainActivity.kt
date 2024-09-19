package com.example.xogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.xogame.ui.theme.XOGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XOGameTheme {
                GameScreen(viewModel = GameViewModel())

            }
        }
    }
}
@Preview
@Composable
fun PreviewScreenInMainActivity(){
    GameScreen(viewModel = GameViewModel())
}

