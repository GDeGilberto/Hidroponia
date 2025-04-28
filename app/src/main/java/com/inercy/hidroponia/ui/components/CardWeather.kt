package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.inercy.hidroponia.R
import com.inercy.hidroponia.data.local.DataSource
import com.inercy.hidroponia.data.remote.api.Hour
import com.inercy.hidroponia.data.remote.api.WeatherModel
import com.inercy.hidroponia.ui.theme.*

@Composable
fun CardWeather(data: WeatherModel) {
    var isDetailsVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 8.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(BlueDarker, BlueBase2, TealSubtle)
                ),
                shape = RoundedCornerShape(8.dp)
            ))
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = data.location.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                color = LightBase
            )
            Text(
                text = data.location.localtime,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                color = LightBase
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "${data.current.temp_c.toInt()}°",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 64.sp,
                            color = LightBase
                        )
                        Text(
                            text = "C",
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = LightBase
                        )
                    }

                    Text(
                        text = "Min ${data.forecast.forecastday[0].day.mintemp_c.toInt()}°C, " +
                                "Max ${data.forecast.forecastday[0].day.maxtemp_c.toInt()}°C",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.fillMaxWidth(),
                        color = LightBase
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = "https:${data.current.condition.icon}",
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                    /*TODO manejar nuestras propias imagenes*/
//                    Image(
//                        painter = painterResource(R.drawable.cloud_with_rain),
//                        contentDescription = null,
//                        modifier = Modifier.size(72.dp)
//                    )
                    Text(
                        text = data.current.condition.text,
                        style = MaterialTheme.typography.bodySmall,
                        color = LightBase
                    )
                }
            }
        }

        if(isDetailsVisible){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightBase)
                    .padding(horizontal = 8.dp, vertical = 10.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                data.forecast.forecastday[0].hour.forEach { hourData: Hour ->
                    ItemWeather(hourData = hourData)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                )
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .clickable { isDetailsVisible = !isDetailsVisible }
                .padding(top = 16.dp, bottom = 24.dp),
            Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.ver_mas),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(16.dp),
            )
        }
    }
}


@Composable
fun ItemWeather(hourData: Hour) {
    Column(
        modifier = Modifier.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = hourData.time.split(" ")[1],
            style = MaterialTheme.typography.bodyMedium,
            color = DarkDarker
        )
        Text(
            text = "${hourData.humidity}%",
            style = MaterialTheme.typography.bodySmall,
            color = BlueDarker
        )
        AsyncImage(
            model = "https:${hourData.condition.icon}",
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
//        Image(
//            painter = painterResource(R.drawable.cloud_with_rain),
//            contentDescription = null,
//            modifier = Modifier.size(32.dp)
//        )
        Text(
            text = "${hourData.temp_c.toInt()}°C",
            style = MaterialTheme.typography.bodySmall,
            color = DarkDarker
        )
    }
}

@Preview
@Composable
fun CardWeatherPreview() {
    HidroponiaTheme(darkTheme = false) {
        CardWeather(data = DataSource.weatherData)
    }
}

@Preview
@Composable
fun CardWeatherDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        CardWeather(data = DataSource.weatherData)
    }
}