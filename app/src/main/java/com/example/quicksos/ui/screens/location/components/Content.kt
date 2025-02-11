package com.example.quicksos.ui.screens.location.components

import MapCompose
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun InformationText(modifier: Modifier = Modifier, text: String) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val fontSize = when {
        screenWidth > 600 -> 18.sp  // Large screens (e.g., tablets)
        screenWidth > 400 -> 16.sp  // Medium screens (e.g., phones)
        else -> 14.sp               // Small screens
    }

    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Adjust padding for better spacing
        fontSize = fontSize,
        fontStyle = MaterialTheme.typography.displayLarge.fontStyle,
        maxLines = 1,
    )
}

@Composable
fun LocationInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        InformationText(text = "Coordinates: (47.583914, -122.150077)")
        InformationText(text = "Address: 1234 Main St, Anytown USA")
    }
}

@Composable
fun HelpButton(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Button(
        onClick = {
            navController.navigate("Home")
        },
        colors = ButtonDefaults.buttonColors(),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp) // Consistent vertical padding
    ) {
        Text(
            text = "Get Help",
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Composable
fun LocationScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MapCompose(modifier = Modifier.weight(0.6f)) // Adjust map size dynamically
        LocationInfo(modifier = Modifier.weight(0.2f)) // Adjust weight for better layout distribution
        HelpButton(
            modifier = Modifier.weight(0.2f), // Adjust weight for button size consistency
            navController = navController,
        )
    }
}