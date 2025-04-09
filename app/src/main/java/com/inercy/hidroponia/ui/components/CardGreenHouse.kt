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
import androidx.compose.material3.Card
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
import com.inercy.hidroponia.ui.theme.BlueDarker
import com.inercy.hidroponia.ui.theme.BlueSubtle
import com.inercy.hidroponia.ui.theme.HidroponiaTheme
import com.inercy.hidroponia.ui.theme.RedDarker
import com.inercy.hidroponia.ui.theme.RedSubtle
import com.inercy.hidroponia.ui.theme.YellowDarker
import com.inercy.hidroponia.ui.theme.YellowSubtle

/**
 * @param title title to be displayed on the card
 * @param light recorded luminosity value
 * @param temp recorded temperature value
 * @param humidity recorded humidity value
 * @param img the id where the local image is stored
 * @param description description of the image for SEO purposes
 */
@Composable
fun CardGreenHouse(
    img: Int = R.drawable.greenhouseisometric,
    description: String = "Image decorative",
    title: String = "Title",
    light: Int = 0,
    temp: Int = 0,
    humidity: Int = 0,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.shadow(elevation = 8.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            Column(
                modifier = modifier
                    .weight(0.6f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = modifier.align(Alignment.Start)
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ClimateMeasurement("$light%", R.drawable.sun, description, YellowDarker,
                        YellowSubtle
                    )
                    ClimateMeasurement("$temp°C", R.drawable.temp, description, RedDarker, RedSubtle)
                    ClimateMeasurement("$humidity%", R.drawable.humidity_indoor, description,
                        BlueDarker, BlueSubtle
                    )
                }
            }

            Column(
                modifier = modifier
                    .weight(0.4f)
                    .fillMaxHeight()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = description,
                    modifier = modifier
                        .size(100.dp)
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun ClimateMeasurement(
    text: String,
    image: Int,
    description: String,
    iconTint: Color,
    backgroundColor: Color,
){
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
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview
@Composable
fun CardGreenHousePreview(){
    HidroponiaTheme(darkTheme = false) {
        CardGreenHouse()
    }
}

@Preview
@Composable
fun CardGreenHouseDarkPreview(){
    HidroponiaTheme(darkTheme = true) {
        CardGreenHouse()
    }
}