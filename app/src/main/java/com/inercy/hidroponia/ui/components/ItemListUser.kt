package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun ItemListUser(
    name: String = "Family Lopez",
    position: String = "Resident",
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            AvatarWithInitials(name = name)
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = position,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun AvatarWithInitials(name: String) {
    val initials = name.split(" ")
        .mapNotNull { it.firstOrNull()?.uppercaseChar()?.toString() }
        .take(2)
        .joinToString("")

    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Preview
@Composable
fun ItemListUserPreview() {
    HidroponiaTheme(darkTheme = false) {
        ItemListUser()
    }
}

@Preview
@Composable
fun ItemListUserDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        ItemListUser()
    }
}