package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

/**
 * @param title display title of the card
 * @param description display description of the card
 */
@Composable
fun CardAction(
    title: String = "Title",
    description: String = "Description",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(24.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.WarningAmber,
                contentDescription = null,
                modifier = modifier.size(40.dp),
            )
            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            HorizontalDivider()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.action))
                }
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.view_photo))
                }
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.view_video))
                }
            }
        }
    }
}

@Preview
@Composable
fun CardActionPreview() {
    HidroponiaTheme(darkTheme = false) {
        CardAction()
    }
}

@Preview
@Composable
fun CardActionDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        CardAction()
    }
}