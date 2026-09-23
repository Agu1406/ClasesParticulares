package model

abstract class Llamada(var nOrigen: String, var nDestino: String, var duracion: Int) {

    var coste: Double = 0.0

    init {
        coste = calcularCoste()
    }

    abstract fun calcularCoste(): Double

    open fun mostrarDatos() {
        println("Origen = $nOrigen")
        println("Destino = $nDestino")
        println("Duracion = $duracion")
        println("Coste = $coste")
    }
}
