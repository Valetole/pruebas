package cl.valentina.pruebasejemplos.api

class StockProductosRepository (
    private val api: StockProductosAPI
        ): SafeApiRequest() {

            suspend fun getStockProductos() = apiRequest {api.getStockProductos()}

}