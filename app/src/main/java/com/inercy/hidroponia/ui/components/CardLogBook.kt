package com.inercy.hidroponia.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.ui.theme.HidroponiaTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CardLogBook(
    title: String = "Title",
    description: String = "Description",
    date: String = "Date",
    responsible: String = "Responsible",
    icon: ImageVector = Icons.Filled.Image,
    color: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(BorderStroke(2.dp, color), shape = RoundedCornerShape(12.dp)),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Row {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = modifier.size(20.dp)
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = modifier.size(16.dp)
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = responsible,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FormatedDate(date: String = "25-11-2024", modifier: Modifier = Modifier) {
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val localDate = LocalDate.parse(date, formatter)

    val dayOfWeek = when (localDate.dayOfWeek) {
        DayOfWeek.MONDAY -> "Lun"
        DayOfWeek.TUESDAY -> "Mar"
        DayOfWeek.WEDNESDAY -> "Mié"
        DayOfWeek.THURSDAY -> "Jue"
        DayOfWeek.FRIDAY -> "Vie"
        DayOfWeek.SATURDAY -> "Sáb"
        DayOfWeek.SUNDAY -> "Dom"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 20.dp)
    ) {
        Text(text = dayOfWeek, style = MaterialTheme.typography.labelSmall)
        Text(text = localDate.dayOfMonth.toString(), style = MaterialTheme.typography.displayLarge)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CardLogBookPreview() {
    HidroponiaTheme(darkTheme = false) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            FormatedDate()
            CardLogBook()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CardLogBookDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            FormatedDate()
            CardLogBook()
        }
    }
}