package com.example.quicksos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.quicksos.ui.screens.SOSHomeScreen
import com.example.quicksos.ui.theme.QuickSOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickSOSTheme(dynamicColor = false) {
                SOSHomeScreen()
            }
        }
    }
}
