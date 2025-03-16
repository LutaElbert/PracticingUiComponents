package com.example.applyinguicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.applyinguicomponents.presentation.util.navigation.MainNavHost
import com.example.applyinguicomponents.presentation.util.sharedcomponents.ScaffoldComponents
import com.example.applyinguicomponents.ui.theme.ApplyingUiComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplyingUiComponentsTheme {
                ScaffoldComponents { paddingValues, navController ->
                    MainNavHost(paddingValues, navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApplyingUiComponentsTheme {

    }
}