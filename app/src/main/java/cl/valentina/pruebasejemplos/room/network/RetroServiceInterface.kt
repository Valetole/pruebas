package cl.valentina.pruebasejemplos.room.network

import cl.valentina.pruebasejemplos.room.StockProductosEntity
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET ("Valetole.json")
   fun getDataFromApi(): Call<List<StockProductosEntity>>
}
