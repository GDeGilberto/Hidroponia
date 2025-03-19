package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R

/**
 * @param text Text displayed on the button
 * @param img Icon or image shown on the button
 * @param description Description of the image for SEO purposes
 */
@Preview
@Composable
fun ButtonIconText(
    text: String = "Button",
    img: Int = R.drawable.farm,
    description: String = "Image decoration"
) {
    Column(
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .width(128.dp)
            .height(128.dp)
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            contentDescription = description,
            painter = painterResource(id = img),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
        )
    }
}