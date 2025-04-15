package com.inercy.hidroponia.domain.models

data class Usuario(
    val userId: Int,
    val username: String,
    val email: String,
    val status: Status,
    val rol: Rol,
)
