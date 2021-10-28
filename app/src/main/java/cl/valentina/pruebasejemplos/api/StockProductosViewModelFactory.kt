package cl.valentina.pruebasejemplos.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class StockProductosViewModelFactory (
    private val repository: StockProductosRepository
        ) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StockProductosViewModel(repository) as T
    }
        }