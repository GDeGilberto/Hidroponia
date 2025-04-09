package com.inercy.hidroponia.ui.components

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

/**
 * @param icon the id where the local image is stored
 * @param title title to be displayed on the card
 * @param description description of the image for SEO purposes
 * @param count count of the product
 */
@SuppressLint("DefaultLocale")
@Composable
fun ItemListInventory(
    @DrawableRes icon: Int = R.drawable.lettuce,
    title: String = "name of the product",
    description: String = "presentation, color",
    count: Int = 0,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(8.dp)
                )
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Text(
                style = MaterialTheme.typography.displayMedium,
                text = String.format("%,d", count),
            )
        }
    }
}

@Preview
@Composable
fun ItemListInventoryPreview() {
    HidroponiaTheme(darkTheme = false) {
        ItemListInventory()
    }
}

@Preview
@Composable
fun ItemListInventoryDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        ItemListInventory()
    }
}