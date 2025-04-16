package com.inercy.hidroponia.domain.models

data class Empresa(
    val id: Int,
    val nombre: String,
    val direccion: String,
    val usuario: List<Usuario>,
    val invernaderos: List<Invernadero>,
    val status: Status
)
