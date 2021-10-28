package cl.valentina.pruebasejemplos.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class StockProductosViewModel(
    private val repository: StockProductosRepository
    ) : ViewModel() {

        private lateinit var job: Job

        private val _stocks = MutableLiveData<List<StockProductos>>()// = MutableLiveData<List<StockProductos>>()
        val stocks: LiveData<List<StockProductos>> // : LiveData<List<StockProductos>>
            get() = _stocks


   fun getStockProductos() { //JOB es un elemento controlador de corrutinas
        job = Coroutines.ioThenMain(
            { repository.getStockProductos() },
            { _stocks.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}