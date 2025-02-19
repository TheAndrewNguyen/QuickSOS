package com.example.quicksos.ui.screens.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun PreferenceCard(modifier: Modifier = Modifier, title: String, description: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.White,
        ),
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                color = androidx.compose.ui.graphics.Color.Black,
                text = title,
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                color = androidx.compose.ui.graphics.Color.Black,
                text = description,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreferenceCardPreview() {
    QuickSOSTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            PreferenceCard(title = "Preferences title", description = "Preferences description")
        }
    }
}
