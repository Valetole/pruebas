package cl.valentina.pruebasejemplos.room


import android.app.Application
import android.content.Context
import cl.valentina.pruebasejemplos.room.network.RetroServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
Pero ¿Que pasaría si queremos inyectar Retrofit?
No podemos ir a la clase Retrofit y ponerle @Inject constructor() porque es una librería externa del proyecto y por ende no nos va a dejar escribir.
Es por ello que podemos crear módulos que nos implementen dependencias más especiales.

 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getData(context: Application): StockProductosDataBase {
        return StockProductosDataBase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun getStockDao(stockProductosDataBase: StockProductosDataBase): StockProductosDAO {
        return stockProductosDataBase.stockProductosDao()
    }

    val url  = "http://valetole.rayunmapu.cl/"

    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit): RetroServiceInterface {
        return retrofit.create(RetroServiceInterface::class.java)

    }


    @Provides
    @Singleton
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}