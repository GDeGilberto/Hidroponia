package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.theme.BlueLight
import com.inercy.hidroponia.ui.theme.BlueStrong
import com.inercy.hidroponia.ui.theme.RedLight
import com.inercy.hidroponia.ui.theme.RedStrong
import com.inercy.hidroponia.ui.theme.YellowLight
import com.inercy.hidroponia.ui.theme.YellowStrong

/**
 * @param title title to be displayed on the card
 * @param light recorded luminosity value
 * @param temp recorded temperature value
 * @param humidity recorded humidity value
 * @param img the id where the local image is stored
 * @param description description of the image for SEO purposes
 */
@Preview
@Composable
fun CardGreenHouse(
    img: Int = R.drawable.greenhouseisometric,
    description: String = "Image decorative",
    title: String = "Title",
    light: Int = 0,
    temp: Int = 0,
    humidity: Int = 0
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(6.dp)
            )
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClimateMeasurement("$light%", R.drawable.sun, description, YellowStrong, YellowLight)
                ClimateMeasurement("$temp°C", R.drawable.temp, description, RedStrong, RedLight)
                ClimateMeasurement("$humidity%", R.drawable.humidity_indoor, description, BlueStrong, BlueLight)
            }
        }

        Column(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = description,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}


@Composable
fun ClimateMeasurement(text: String, image: Int, description: String, iconTint: Color, backgroundColor: Color){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = backgroundColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ){
            Image(
                contentDescription = description,
                painter = painterResource(id = image),
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(iconTint)
            )
        }

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}