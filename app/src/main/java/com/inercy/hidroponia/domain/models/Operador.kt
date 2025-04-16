package com.inercy.hidroponia.domain.models

data class Operador(
    val usuario: Usuario,
    val invernaderos: List<Invernadero>
)
