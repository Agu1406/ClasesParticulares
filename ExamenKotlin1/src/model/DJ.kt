package model

class DJ(
    id: Int,
    nombre: String,
    pais: String,
    var horasSesion: Int,
    var internacional: Boolean
) : Artista(id, nombre, pais) {

    // horas * 100 si internacional se dobla
    override fun calcularCache(): Int {
        var cache = horasSesion * 100
        if (internacional) {
            cache = cache * 2
        }
        return cache
    }

    override fun mostrarDatos(): Unit {
        println("Tipo = DJ")
        super.mostrarDatos()
        println("horasSesion = ${horasSesion}")
        println("internacional = ${internacional}")
    }
}
