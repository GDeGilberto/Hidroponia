package com.inercy.hidroponia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R

/**
 * @param title The name of the module.
 * @param vegetable The name of the vegetable in the module.
 * @param variety The variety of the vegetable for additional context.
 * @param greenhouse The name of the greenhouse where the module is located.
 * @param status The status of the module.
 * @param img A painterResource for the local image.
 * @param description A description of the image for accessibility purposes.
 */
@Preview
@Composable
fun HeaderModule(
    title: String = "Modulo 1",
    vegetable: String = "Vegetable",
    variety: String = "variety",
    greenhouse: String = "GreenHouse Norte",
    status: String = "Status",
    img: Int = R.drawable.lettuce,
    description: String = "image vegetable"
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFFF1B7B7))) {
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
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Place,
                        contentDescription = description,
                    )
                    Text(
                        text = greenhouse,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = status,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(2.dp))
                            .background(Color(0XFFDB9191))
                            .padding(horizontal = 12.dp, vertical =  4.dp)
                    )
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