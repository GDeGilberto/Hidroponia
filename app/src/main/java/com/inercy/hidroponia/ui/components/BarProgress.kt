package com.inercy.hidroponia.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.enums.StatusEnum

/**
 * @param iconLabel Path of the drawable for the icon accompanying the label
 * @param color The color to tint the icon accompanying the label
 * @param value Data corresponding to the represented property
 * @param min Minimum tolerated value
 * @param max Maximum tolerated value
 */
@Preview(showBackground = true)
@Composable
fun BarProgress(
    @DrawableRes iconLabel: Int = R.drawable.sun,
    label: String = stringResource(R.string.title),
    color: Color = Color.Black,
    value: Float = 0f,
    min: Float = 0f,
    max: Float = 100f,
    modifier: Modifier = Modifier
) {
    val status = when {
        value == 0f -> StatusEnum.Information
        value <= min + (max - min) * 0.10f || (value < min || value > max) -> StatusEnum.Error
        value <= min + (max - min) * 0.20f -> StatusEnum.Warning
        else -> StatusEnum.OK
    }

    Row(modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(modifier = modifier.padding(horizontal = 4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = iconLabel),
                        tint = color,
                        contentDescription = null,
                        modifier = modifier.size(16.dp))
                    Text(
                        text = label,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(modifier = modifier.weight(1f),
                    horizontalArrangement = Arrangement.End
                ) {
                    InformationText(
                        R.drawable.sun,
                        label = stringResource(R.string.min),
                        value = min.toInt()
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    InformationText(
                        R.drawable.sun,
                        label = stringResource(R.string.max),
                        value = max.toInt()
                    )
                }
            }
            BarSimple(value, min, max, color = status.color, colorLight = status.colorLight)
        }

        Column(modifier = modifier.padding(start = 8.dp)) {
            Icon(
                imageVector = status.icon,
                contentDescription = null,
                tint = status.color,
                modifier = modifier.size(20.dp)
            )
        }

    }
}

@Composable
fun BarSimple(
    value: Float,
    min: Float,
    max: Float,
    color: Color,
    colorLight: Color = Color.LightGray,
    modifier: Modifier = Modifier
) {
    val progress = (value - min).coerceIn(0f, max - min) / (max - min) // Normalization progress

    //surface
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colorLight)
    ) {
        //bar color
        Box(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(fraction = progress)
                .clip(RoundedCornerShape(16.dp))
                .background(color)
        )
    }
}


@Composable
fun InformationText(
    @DrawableRes icon: Int,
    label: String,
    value: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(text = "$label: $value")
    }
}