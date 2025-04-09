package com.inercy.hidroponia.data.model

data class Invernadero(
    val nombre: String,
    val modulo: List<Modulo>?,
    val estatus: Status,
    val inventario: Inventario?
)
