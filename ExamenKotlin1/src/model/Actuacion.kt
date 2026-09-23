package model

class Actuacion(
    var id: Int,
    var artista: Artista,
    var escenario: Escenario,
    var duracion: Int,
    var horaInicio: Int
) {

    fun horaFin(): Int {
        return horaInicio + duracion
    }

    fun solapaCon(otra: Actuacion): Boolean {
        return horaInicio < otra.horaFin() && otra.horaInicio < horaFin()
    }

    fun mostrarDatos(): Unit {
        println("id = ${id}")
        println("duracion = ${duracion}")
        println("horaInicio = ${horaInicio}")
        println("artista:")
        artista.mostrarDatos()
        println("escenario:")
        escenario.mostrarDatos()
    }
}
