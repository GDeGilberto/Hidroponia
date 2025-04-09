package com.inercy.hidroponia.data.model

data class Usuario(
    val userId: Int,
    val username: String,
    val email: String,
    val status: Status,
    val rol: Rol,
)
