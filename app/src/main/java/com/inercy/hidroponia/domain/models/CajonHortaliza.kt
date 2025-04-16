package com.inercy.hidroponia.domain.models

import java.util.Date

data class CajonHortaliza(
    val nombre: String,
    val cantidad: Int,
    val fecha: Date,
    val hortaliza: Hortaliza
)
