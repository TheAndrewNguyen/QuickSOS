package com.example.quicksos.ui.screens.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.ui.screens.settings.viewModel.SettingsViewModel
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun PreferenceCardText(
    title: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
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


@Composable
fun PreferenceCardBase(
    title: String, description: String,
    viewModel: SettingsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    content: @Composable (viewModel: SettingsViewModel) -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color.White,
        ),
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ) {
            //title and description
            PreferenceCardText(title = title, description = description)

            //toggle button
            content(viewModel)
        }
    }
}

//TODO: Refactor this to use the basePreferenceCard
@Composable
fun SliderPreferenceCard(
    title: String, description: String,
    viewModel: SettingsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    ) {
    PreferenceCardBase(
        title = title,
        description = description,
        modifier = modifier,
        content = {
            Switch(
                checked = viewModel.darkTheme.value,
                onCheckedChange = { viewModel.toggleDarkTheme() },
                modifier = Modifier.padding(16.dp)
           )
        })
}


//TODO: implement checkbox preference card
@Composable
fun CheckBoxPreferenceCard(
    title: String, description: String,
    viewModel: SettingsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {

}

@Preview(showBackground = true)
@Composable
fun PreferenceCardBasePreview() {
    QuickSOSTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            PreferenceCardBase(title = "Preferences title", description = "Preferences description")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SliderPreferenceCardPreview() {
    QuickSOSTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            SliderPreferenceCard(
                title = "Preferences title",
                description = "Preferences description"
            )
        }
    }
}

