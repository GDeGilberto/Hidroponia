package com.inercy.hidroponia.domain.models

import java.util.Date

data class BitacoraParametrosAmbientales(
    val fecha: Date,
    val usuario: Usuario,
    val hortaliza: Hortaliza,
    val etapaVegetativa: EtapaVegetativa
)
