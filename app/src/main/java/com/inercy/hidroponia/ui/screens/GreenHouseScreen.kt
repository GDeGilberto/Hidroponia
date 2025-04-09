package com.inercy.hidroponia.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.components.ButtonIconText
import com.inercy.hidroponia.ui.components.HeaderTitleSimple
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

enum class Buttons(val text: String, @DrawableRes val img: Int) {
    Modelo("Modelo", R.drawable.farm),
    Inventario("Inventario", R.drawable.inventario_farm),
    AlmacenHortaliza("Almacen Hortaliza", R.drawable.almacen_farm),
    Mantenimiento("Mantenimiento", R.drawable.clear_farm),
    Residentes("Residentes", R.drawable.family_farm)
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GreenHouseScreen(modifier: Modifier = Modifier) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            HeaderTitleSimple()
            Text(
                text = stringResource(R.string.title_list_buttons),
                style = MaterialTheme.typography.displayMedium,
            )

            FlowRow(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                maxItemsInEachRow = 2
            ) {
                Buttons.entries.forEach { button ->
                    ButtonIconText(
                        text = button.text,
                        img = button.img
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun GreenHouseScreenPreview() {
    HidroponiaTheme(darkTheme = false) {
        GreenHouseScreen()
    }
}

@Preview
@Composable
fun GreenHouseScreenDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        GreenHouseScreen()
    }
}