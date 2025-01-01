package com.example.quicksos.ui.components

import android.R.attr.contentDescription
import android.R.attr.label
import android.R.attr.onClick
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.theme.QuickSOSTheme
import androidx.compose.runtime.mutableStateOf


//items for NavBar
val items = listOf("Action", "Location", "Settings")
val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.LocationOn, Icons.Filled.Settings)
val unselectedIcons = listOf(Icons.Outlined.Home, Icons.Outlined.LocationOn, Icons.Outlined.Settings)

@Composable
fun NavBar(modifier: Modifier = Modifier) {
    var selectedItem = remember { mutableIntStateOf(0) }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem.intValue == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = selectedItem.intValue == index,
                onClick = { selectedItem.intValue = index }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavBarPreview() {
    QuickSOSTheme {
        NavBar()
    }
}