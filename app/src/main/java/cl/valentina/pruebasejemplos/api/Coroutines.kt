package cl.valentina.pruebasejemplos.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    fun<T: Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =
        //objeto que inicializa una o mas corrutina
        CoroutineScope((Dispatchers.Main)).launch {
            //Dispatchers.Main hilo principal libre para hacer otras cosas
            val data = CoroutineScope(Dispatchers.IO).async rt@ {
                return@rt work()
                //Dispatchers.IO tareas de llamadas a base de datos o servidores. No bloquea el hilo principal
            }.await()
            callback(data)
        }
    }

//Cómo iniciar una corrutina
//Puedes iniciar corrutinas de dos maneras:
//
//launch inicia una corrutina nueva y no le muestra el resultado al llamador. Cualquier trabajo que se considere "activar y olvidar" se puede iniciar con launch.
//async inicia una corrutina nueva y te permite mostrar un resultado con una función suspendida llamada await.
//Por lo general, como una función regular no puede llamar a await, debes usar launch para lanzar una corrutina nueva desde una función regular.
// Usa el objeto async solo cuando esté dentro de otra corrutina o cuando esté dentro de una función suspendida y realice una descomposición paralela.