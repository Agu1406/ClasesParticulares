package model

class LlamadaProvincial(nOrigen: String, nDestino: String, duracion: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    override fun calcularCoste(): Double {
        // 15 centimos el segundo
        return duracion * 0.15
    }

    override fun mostrarDatos() {
        println("Tipo = Provincial")
        super.mostrarDatos()
    }
}
