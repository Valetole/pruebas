package cl.valentina.pruebasejemplos.api

import retrofit2.Response
import java.io.IOException

//Llama a la api

abstract class SafeApiRequest {

    suspend fun <T:Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if(response.isSuccessful) {
            return response.body()!!
        } else {
            //Todo handle api exception
            throw ApiException(response.code().toString())
        }

    }
}
class ApiException(message: String): IOException(message)