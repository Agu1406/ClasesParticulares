package model

class LlamadaNacional(
    nOrigen: String,
    nDestino: String,
    duracion: Int,
    var franja: Int
) : Llamada(nOrigen, nDestino, duracion) {

    override fun calcularCoste(): Double {
        val precioSegundo = when (franja) {
            1 -> 0.20
            2 -> 0.25
            3 -> 0.30
            else -> 0.20
        }
        return duracion * precioSegundo
    }

    override fun mostrarDatos() {
        println("Tipo = Nacional")
        println("Franja = $franja")
        super.mostrarDatos()
    }
}
