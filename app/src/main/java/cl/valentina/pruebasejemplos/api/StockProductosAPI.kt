package cl.valentina.pruebasejemplos.api

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// metodo por el cual accedemos a nuestra api
interface StockProductosAPI {

    @GET("Valetole.json")
    suspend fun getStockProductos(): Response<List<StockProductos>> //: Response<List<StockProductos>>

    companion object {
        operator fun invoke () : StockProductosAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://valetole.rayunmapu.cl/")
                .build()
                .create(StockProductosAPI::class.java)

        }
    }
}