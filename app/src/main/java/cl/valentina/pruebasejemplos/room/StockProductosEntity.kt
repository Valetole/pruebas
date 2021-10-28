package cl.valentina.pruebasejemplos.room

import androidx.room.Entity
import androidx.room.PrimaryKey

// tabla o entity
@Entity(tableName = "STOCKS")
data class StockProductosEntity(
    @PrimaryKey val id: Int?,
    val cantidad: Int?,
    val descripcion: String?,
    val nombre: String?,
    val precio: String?,
    val url: String?
)