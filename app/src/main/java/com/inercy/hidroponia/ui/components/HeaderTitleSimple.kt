package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

/**
 * @param text title of the header
 * @param img image or icon displayed in the header
 */
@Composable
fun HeaderTitleSimple(
    text: String = "Title",
    img: Int = R.drawable.greenhouseisometric,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(color = Color(0xFFD9E9D9))){
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(128.dp)
                .offset(x = 40.dp)
                .clip(CircleShape)
                .background(color = Color(0XFFA9D0B8))
        )

        Row (
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = text,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier.weight(2f)
            )

            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Preview
@Composable
fun HeaderTitleSimplePreview() {
    HidroponiaTheme(darkTheme = false) {
        HeaderTitleSimple()
    }
}

@Preview
@Composable
fun HeaderTitleSimpleDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        HeaderTitleSimple()
    }
}