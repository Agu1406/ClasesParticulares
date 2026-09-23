package model

class Solista(
    id: Int,
    nombre: String,
    pais: String,
    var numeroDiscos: Int,
    var instrumento: String
) : Artista(id, nombre, pais) {

    // cache 1000 + discos * 2
    override fun calcularCache(): Int {
        return 1000 + (numeroDiscos * 2)
    }

    override fun mostrarDatos(): Unit {
        println("Tipo = Solista")
        super.mostrarDatos()
        println("numeroDiscos = ${numeroDiscos}")
        println("instrumento = ${instrumento}")
    }
}
