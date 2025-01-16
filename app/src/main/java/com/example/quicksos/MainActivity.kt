package com.example.quicksos

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.quicksos.navigation.AppNavigation
import com.example.quicksos.ui.theme.QuickSOSTheme
import org.osmdroid.config.Configuration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //osmdroid
        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        Configuration.getInstance().userAgentValue = "QuickSOS"

        setContent {
            QuickSOSTheme(dynamicColor = false) {
                AppNavigation(Modifier.fillMaxSize())
            }
        }
    }
}
