package com.inercy.hidroponia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Https
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.components.HeaderTitleSimple
import com.inercy.hidroponia.ui.navigation.AppDestination
import com.inercy.hidroponia.ui.screens.login.AuthState
import com.inercy.hidroponia.ui.screens.login.LoginViewModel
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val authState = viewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate(AppDestination.Login.route)
            else -> Unit
        }
    }

    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            HeaderTitleSimple(
                text = stringResource(R.string.user),
                img = R.drawable.key,
                modifier = Modifier.background(MaterialTheme.colorScheme.onErrorContainer)
            )
            Box(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                ButtonLogOut(loginViewModel = viewModel)
            }

        }
    }
}

@Composable
fun ButtonLogOut(
    loginViewModel: LoginViewModel,
    modifier: Modifier = Modifier
) {
    FilledTonalButton(
        onClick = { loginViewModel.signOut() },
        enabled = true,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.Https,
            contentDescription = null,
            modifier = modifier.size(ButtonDefaults.IconSize)
        )
        Text(text = stringResource(R.string.log_off), modifier.padding(start = 4.dp))
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val loginViewModel = LoginViewModel()
    val navController = rememberNavController()
    HidroponiaTheme(darkTheme = false) {
        ProfileScreen(navController, loginViewModel)
    }
}

@Preview
@Composable
fun ProfileScreenDarkPreview() {
    val loginViewModel = LoginViewModel()
    val navController = rememberNavController()
    HidroponiaTheme(darkTheme = true) {
        ProfileScreen(navController, loginViewModel)
    }
}