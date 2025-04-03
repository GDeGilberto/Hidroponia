package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.models.StatusEnum

@Preview(showBackground = true)
@Composable
fun StateOfLife(
    title: String = stringResource(R.string.title),
    days: Int = 0,
    progress: Float = 0f,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.dias_de_germinacion, days),
            modifier = modifier.padding(bottom = 8.dp)
        )
        BarSimple(
            value = progress,
            min = 0f,
            max = 100f,
            color = StatusEnum.OK.color
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.plantacion))
            Text(text = stringResource(R.string.germinacion))
            Text(text = stringResource(R.string.maduracion))
            Text(text = stringResource(R.string.cosecha))
        }
    }
}