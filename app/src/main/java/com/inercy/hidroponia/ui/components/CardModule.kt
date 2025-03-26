package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R

@Preview
@Composable
fun CardModule(
    title: String = "Modulo 1",
    vegetable: String = "Vegetable",
    variety: String = "variety",
    dateStart: String = "28/11/2021",
    dateEnd: String = " 04/04/2025",
    cant: Int = 50,
    img: Int = R.drawable.farm,
    description: String = "image vegetable"
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .shadow(
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        )
        .background(color = Color(0xFFD9E9D9))) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(110.dp)
                .offset(x = 40.dp)
                .clip(CircleShape)
                .background(color = Color(0XFFA9D0B8))
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = vegetable,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = variety,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Column {
                        Text(
                            text = "$cant ${stringResource(R.string.plantadas)}",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.End
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.inicio),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = dateStart,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column {
                        Text(
                            text = stringResource(R.string.termina),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = dateEnd,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Image(
                contentDescription = description,
                painter = painterResource(id = img),
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}