package cl.valentina.pruebasejemplos.room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cl.valentina.pruebasejemplos.room.StockProductosEntity
import cl.valentina.pruebasejemplos.room.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: RetroRepository
): ViewModel() {

    fun getStockProductos(): LiveData<List<StockProductosEntity>> {
        return repository.getStock()
    }

    fun makeApiCall() {
        repository.callApi()
    }
}

//viewModelScope.launch(Dispatchers.IO) {}
//insertar acá corrutina viewmodelScope.launch(Dispatchers.IO) {}