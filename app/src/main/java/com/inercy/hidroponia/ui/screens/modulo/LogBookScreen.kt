package com.inercy.hidroponia.ui.screens.modulo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.ui.navigation.HidroponiaAppBar
import com.inercy.hidroponia.ui.navigation.HidroponiaScreen
import com.inercy.hidroponia.R
import com.inercy.hidroponia.data.DataSource
import com.inercy.hidroponia.ui.components.CardLogBook
import com.inercy.hidroponia.ui.components.FormatedDate
import com.inercy.hidroponia.ui.theme.HidroponiaTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LogBookScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.Log),
            style = MaterialTheme.typography.displayMedium
        )

        var previousDate: String? = null
        var previousMonth: String? = null
        val monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy")

        DataSource.logs.forEach { log ->
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val currentDate = LocalDate.parse(log.date, formatter)
            val currentMonth = currentDate.format(monthFormatter)

            if (currentMonth != previousMonth) {
                Text(
                    text = currentMonth,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.align(Alignment.Start)
                )
                previousMonth = currentMonth
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (log.date != previousDate) {
                    FormatedDate(log.date, modifier = Modifier.width(80.dp))
                } else {
                    Spacer(modifier = Modifier.width(80.dp))
                }
                CardLogBook(
                    log.title,
                    log.description,
                    log.date,
                    log.responsible,
                    log.log.icon,
                    log.log.color,
                )
                previousDate = log.date
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun LogBookScreenPreview() {
    HidroponiaTheme(darkTheme = false) {
        Scaffold(
            topBar = {
                HidroponiaAppBar(
                    currentScreen = HidroponiaScreen.Home,
                    canNavigateBack = false,
                    navigateUp = {}
                )
            }
        ) { innerPadding ->
            LogBookScreen(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(innerPadding)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun LogBookScreenDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        Scaffold(
            topBar = {
                HidroponiaAppBar(
                    currentScreen = HidroponiaScreen.Home,
                    canNavigateBack = false,
                    navigateUp = {}
                )
            }
        ) { innerPadding ->
            LogBookScreen(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(innerPadding)
            )
        }
    }
}