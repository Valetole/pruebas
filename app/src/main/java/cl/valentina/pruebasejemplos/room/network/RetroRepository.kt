package cl.valentina.pruebasejemplos.room.network

import androidx.lifecycle.LiveData
import cl.valentina.pruebasejemplos.room.StockProductosDAO
import cl.valentina.pruebasejemplos.room.StockProductosEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(
    private val retroServiceInterface: RetroServiceInterface,
    private val stockProductosDAO: StockProductosDAO
) {
    fun getStock(): LiveData<List<StockProductosEntity>> {
        return stockProductosDAO.getStockProductos()
    }

    fun insertStock(stockProductosEntity: StockProductosEntity) {
        stockProductosDAO.insertStockProductos(stockProductosEntity)
    }
    fun callApi() { //Solicitud asincrónica
        val call: Call<List<StockProductosEntity>> = retroServiceInterface.getDataFromApi()
        call?.enqueue(object: Callback<List<StockProductosEntity>> {
            override fun onResponse(
                call: Call<List<StockProductosEntity>>,
                response: Response<List<StockProductosEntity>>
            ) {
                if (response.isSuccessful) {
                    stockProductosDAO.deleteStockProductos()
                    response.body()?.forEach {
                        insertStock(it)
                    }
                }//Agregar try catch
            }

            override fun onFailure(call: Call<List<StockProductosEntity>>, t: Throwable) {

            }
        })

    }
}
//