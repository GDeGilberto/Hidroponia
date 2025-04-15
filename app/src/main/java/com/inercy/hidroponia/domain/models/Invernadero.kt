package com.inercy.hidroponia.domain.models

data class Invernadero(
    val nombre: String,
    val modulo: List<Modulo>?,
    val estatus: Status,
    val inventario: Inventario?
)
