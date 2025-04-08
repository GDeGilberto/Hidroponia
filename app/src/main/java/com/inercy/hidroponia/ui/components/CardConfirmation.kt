package com.inercy.hidroponia.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

/**
 * @param onDismiss eject exit confirmation dialog
 * @param image image to show
 * @param title title to show
 * @param description description to show
 * @param buttonMessage button message to show
 */
@Composable
fun CardConfirmation(
    onDismiss: () -> Unit,
    @DrawableRes image: Int = R.drawable.done,
    title: String = stringResource(R.string.Dialog_successful_title),
    description: String = stringResource(R.string.Dialog_successful_description),
    buttonMessage: String = stringResource(R.string.ok),
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    ) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = modifier.size(200.dp)
                )

                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall,
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(buttonMessage)
                }
            }
        }
    }
}

@Preview
@Composable
fun CardConfirmationPreview() {
    var showDialog by remember { mutableStateOf(false) }
    HidroponiaTheme(darkTheme = false) {
        CardConfirmation(onDismiss = { showDialog = false })
    }
}

@Preview
@Composable
fun CardConfirmationDarkPreview() {
    var showDialog by remember { mutableStateOf(false) }
    HidroponiaTheme(darkTheme = true) {
        CardConfirmation(onDismiss = { showDialog = false })
    }
}