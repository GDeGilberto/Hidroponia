package com.inercy.hidroponia.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.inercy.hidroponia.R
import com.inercy.hidroponia.data.local.DataSource.invernaderos
import com.inercy.hidroponia.ui.components.CardGreenHouse
import com.inercy.hidroponia.ui.components.CardWeather
import com.inercy.hidroponia.ui.navigation.AppDestination
import com.inercy.hidroponia.ui.screens.auth.AuthState
import com.inercy.hidroponia.ui.screens.auth.AuthViewModel
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun HomeScreen(
    navController: NavController,
    authViewModel: AuthViewModel,
    modifier: Modifier = Modifier
) {
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate(AppDestination.Login.route)
            else -> Unit
        }
    }

    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            TextButton(onClick = { authViewModel.signOut() }) {
                Text(text = "cerrar sesion")
            }
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
    val navController = rememberNavController()
    val authViewModel = AuthViewModel()
    HidroponiaTheme(darkTheme = false) {
        HomeScreen(navController, authViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun HidroponiaHomeScreenDarkPreview() {
    val navController = rememberNavController()
    val authViewModel = AuthViewModel()
    HidroponiaTheme(darkTheme = true) {
        HomeScreen(navController, authViewModel)
    }
}