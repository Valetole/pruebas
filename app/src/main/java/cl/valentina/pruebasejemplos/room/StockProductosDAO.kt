package cl.valentina.pruebasejemplos.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Metodos de la base de datos con los que se accede a la entity
@Dao
interface StockProductosDAO {

    @Query("SELECT * FROM STOCKS ")
     fun getStockProductos(): LiveData<List<StockProductosEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStockProductos(stockProductos: StockProductosEntity)

    @Query("DELETE FROM STOCKS")
     fun deleteStockProductos()
}