import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.quicksos.data.db.entity.Contact


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndividualContactDialog(contact: Contact, onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(150.dp)
        ) {
            TopAppBar(
                title = {
                    Text(
                        text = "${contact.firstName} ${contact.lastName}",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                },
                actions = {
                    //edit contact button
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "edit contact",
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .clickable {
                                //TODO: edit contact
                            }
                    )
                    //delete contact button
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "delete contact",
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    //Close button
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "exit dialog box",
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .clickable {
                                onDismissRequest()
                            }
                    )
                }
            )
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                //subtitle: Phone number
                Text(
                    text = "Phone number",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                //phone number
                Text(
                    text = "${contact.phoneNumber}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndividualContactDialogPreview() {
    val contact = Contact(
        firstName = "John",
        lastName = "Doe",
        phoneNumber = "1234567890"
    )

    IndividualContactDialog(contact = contact, onDismissRequest = {})
}



