package cl.valentina.pruebasejemplos.api

import androidx.room.Entity


data class StockProductos(
    val cantidad: Int,
    val descripcion: String,
    val id: Int,
    val nombre: String,
    val precio: String,
    val url: String
)