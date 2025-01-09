package com.example.quicksos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.quicksos.navigation.AppNavigation
import com.example.quicksos.ui.theme.QuickSOSTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QuickSOSTheme(dynamicColor = false) {
                AppNavigation(Modifier.fillMaxSize())
            }
        }
    }
}
