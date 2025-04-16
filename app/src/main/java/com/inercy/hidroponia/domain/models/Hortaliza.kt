package com.inercy.hidroponia.domain.models

data class Hortaliza(
    val nombre: String,
    val informacion: String,
    val parametros: List<Parametro>,
    val enfermedades: List<Enfermedad>
)
