package com.inercy.hidroponia.ui

import com.inercy.hidroponia.domain.models.Usuario

data class UserProfileUiState(
    val user: Usuario? = null,

    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null
)
