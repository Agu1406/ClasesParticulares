package model

class LlamadaLocal(nOrigen: String, nDestino: String, duracion: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    override fun calcularCoste(): Double {
        return 0.0
    }

    override fun mostrarDatos() {
        println("Tipo = Local")
        super.mostrarDatos()
    }
}
