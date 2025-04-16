package com.inercy.hidroponia.domain.models

import android.media.Image

data class Enfermedad(
    val nombre: String,
    val descripcion: String,
    val foto: Image,
)
