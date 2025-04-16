package com.inercy.hidroponia.domain.models

data class Inventario(
    val nombre: String,
    val cajonHortaliza: List<CajonHortaliza>
)
