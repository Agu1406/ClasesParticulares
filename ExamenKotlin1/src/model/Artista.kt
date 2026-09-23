package model

abstract class Artista(var id: Int, var nombre: String, var pais: String) {

    abstract fun calcularCache(): Int

    open fun mostrarDatos(): Unit {
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("pais = ${pais}")
        println("cache = ${calcularCache()}")
    }
}
