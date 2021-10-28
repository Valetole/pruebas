package cl.valentina.pruebasejemplos.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Clase abstracta que extiende de RoomDatabase, contiene un metodo abstracto para acceder al DAO
@Database (entities =[StockProductosEntity::class],version = 1,exportSchema = false)
abstract class StockProductosDataBase : RoomDatabase() {

    abstract fun stockProductosDao(): StockProductosDAO

    companion object {
        @Volatile
        private var instance: StockProductosDataBase? = null

        fun getDatabase(context: Context) :StockProductosDataBase {
            if(instance == null) {
                instance=Room.databaseBuilder(context.applicationContext, StockProductosDataBase::class.java,"STOCK BD")
                    .allowMainThreadQueries()//Revisar esto
                    .build()

            }
            return  instance!!

        }
    }
}


