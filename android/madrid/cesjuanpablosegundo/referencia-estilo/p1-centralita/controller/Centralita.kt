package controller

import model.Llamada
import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial

class Centralita {

    lateinit var llamadas: ArrayList<Llamada>

    init {
        llamadas = arrayListOf()
    }

    fun registrarLlamada(llamada: Llamada) {
        llamadas.add(llamada)
        println("Llamada registrada")
        llamada.mostrarDatos()
    }

    fun mostrarLlamadas() {
        if (llamadas.isEmpty()) {
            println("No hay llamadas registradas")
            return
        }
        llamadas.forEach { it.mostrarDatos() }
    }

    fun mostrarCostesTotales() {
        var total = 0.0
        llamadas.forEach { total += it.coste }
        println("Coste total = $total")
    }
}
