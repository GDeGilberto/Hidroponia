package com.inercy.hidroponia.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.data.local.DataSource.invernaderos
import com.inercy.hidroponia.ui.components.CardGreenHouse
import com.inercy.hidroponia.ui.components.CardWeather
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            CardWeather()

            Text(
                text = stringResource(R.string.title_list_invernaderos),
                style = MaterialTheme.typography.displayMedium
            )

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                invernaderos.forEach { item ->
                    CardGreenHouse(
                        title = item.nombre,
                        onClick = {  },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HidroponiaHomeScreenPreview() {
    HidroponiaTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HidroponiaHomeScreenDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        HomeScreen()
    }
}