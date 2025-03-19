package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.inercy.hidroponia.ui.theme.*

@Preview
@Composable
fun CardGreenHouse() {
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
                text = "Invernadero Norte",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClimateMeasurement("38%", R.drawable.sun, YellowStrong, YellowLight)
                ClimateMeasurement("22°C", R.drawable.temp, RedStrong, RedLight)
                ClimateMeasurement("31%", R.drawable.humidity_indoor, BlueStrong, BlueLight)
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
                painter = painterResource(id = R.drawable.greenhouseisometric), //parametrisar la imagen a mostrar
                contentDescription = "Imagen decorativa",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}


@Composable
fun ClimateMeasurement(text: String, image: Int, iconTint: Color, backgroundColor: Color){
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
                contentDescription = "Icono del clima",
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