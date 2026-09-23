package model

class Grupo(
    id: Int,
    nombre: String,
    pais: String,
    var componentes: Int,
    var genero: String
) : Artista(id, nombre, pais) {

    // cache 1500 + componentes * 4
    override fun calcularCache(): Int {
        return 1500 + (componentes * 4)
    }

    override fun mostrarDatos(): Unit {
        println("Tipo = Grupo")
        super.mostrarDatos()
        println("componentes = ${componentes}")
        println("genero = ${genero}")
    }
}
