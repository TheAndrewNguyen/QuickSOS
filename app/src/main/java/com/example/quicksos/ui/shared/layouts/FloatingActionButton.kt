package com.example.quicksos.ui.shared.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun CustomFloatingActionButton(icon: ImageVector, onClick: () -> Unit = {}, contentDescription: String) {
    FloatingActionButton(onClick = onClick) {
        Icon(icon, contentDescription)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    QuickSOSTheme(dynamicColor = false) {
        CustomFloatingActionButton(icon = Icons.Filled.Add, contentDescription = "Add")
    }
}