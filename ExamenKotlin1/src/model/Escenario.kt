package model

class Escenario(var id: Int, var nombre: String, var capacidad: Int) {

    fun mostrarDatos(): Unit {
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("capacidad = ${capacidad}")
    }
}
