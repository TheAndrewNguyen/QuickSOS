//package com.example.quicksos.ui.screens.emergencyContacts.components
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//import com.example.quicksos.data.db.entity.Contact
//import com.example.quicksos.ui.theme.QuickSOSTheme
//
//@Composable
//fun SubsectionTitle(title: String) {
//    Text(
//        text = title,
//        style = MaterialTheme.typography.titleMedium,
//        modifier = Modifier.padding(bottom = 8.dp)
//    )
//}
//
//@Composable
//fun IndividualContactCard(contact: Contact) {
//    Dialog(onDismissRequest = {}) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .height(200.dp)
//        ) {
//            //first name
//            SubsectionTitle(title = "First name")
//            //last name
//            SubsectionTitle(title = "Last name")
//            //phone number
//            SubsectionTitle(title = "Phone number")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun IndividualContactCardPreview() {
//    QuickSOSTheme {
//        IndividualContactCard(
//            contact = Contact(
//                firstName = "John",
//                lastName = "Doe",
//                phoneNumber = "123-456-7890"
//            )
//        )
//    }
//}
