package com.example.hello_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hello_compose.data.ContactBook
import com.example.hello_compose.model.Contact

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.weight(0.5F),
                contentAlignment = Alignment.Center
            ) {
                ContactImage(contact.imageRes, contact.getInitials())
            }
            Column(
                modifier = Modifier
                    .weight(0.5F),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ContactName(contact.name, contact.surname, contact.familyName, contact.isFavorite)
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(0.75F),
        ) {
            InfoRow(stringResource(id = R.string.phone), contact.phone)
            InfoRow(stringResource(id = R.string.address), contact.address)
            contact.email?.let {
                InfoRow(stringResource(id = R.string.email), contact.email)
            }
        }
    }
}

@Composable
fun ContactImage(image: Int?, initials: String) {
    if (image != null) {
        Image(
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .fillMaxSize(),
            alignment = Alignment.Center,
            painter = painterResource(id = image),
            contentScale = ContentScale.FillHeight,
            contentDescription = null,
        )
    } else {
        Box(
            modifier = Modifier.padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.circle),
                tint = Color.LightGray,
                contentDescription = null,
            )
            Text(
                style = MaterialTheme.typography.h6,
                text = initials
            )
        }
    }

}

@Composable
fun ContactName(firstName: String, surname: String?, lastName: String, isFavorite: Boolean) {
    Text(
        style = MaterialTheme.typography.h6,
        text = "$firstName ${surname.orEmpty()}"
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            style = MaterialTheme.typography.h5,
            text = lastName
        )
        if (isFavorite) {
            Image(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = android.R.drawable.star_big_on),
                contentDescription = null
            )
        }
    }
}

@Composable
fun InfoRow(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5F)
                .padding(0.dp, 0.dp, 8.dp, 0.dp),
            textAlign = TextAlign.Right,
            style = TextStyle(
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
            ),
            text = "$title: "
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5F),
            style = MaterialTheme.typography.body2,
            text = value
        )
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactDetailsPreview() {
    ContactDetails(ContactBook.getContact(0))
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactDetailsPreview2() {
    ContactDetails(ContactBook.getContact(1))
}