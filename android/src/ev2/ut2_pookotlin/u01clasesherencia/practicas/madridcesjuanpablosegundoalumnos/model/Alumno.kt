package model

class Alumno(
    val id: Int,
    var nombre: String,
    var apellido: String
) {

    var telefono: String? = null
    var correo: String? = null
    var calificacion: Double = 0.0
    var matriculado: Boolean = true

    constructor(
        id: Int,
        nombre: String,
        apellido: String,
        telefono: String?,
        correo: String?
    ) : this(id, nombre, apellido) {
        this.telefono = telefono
        this.correo = correo
    }

    fun mostrarDatos() {
        println("id = $id")
        println("nombre = $nombre")
        println("apellido = $apellido")
        println("telefono = ${telefono ?: "dato no disponible"}")
        println("correo = ${correo ?: "dato no disponible"}")
        println("calificacion = $calificacion")
        println("matriculado = $matriculado")
    }

    fun desmatricular() {
        matriculado = false
        println("Alumno desmatriculado")
    }

    fun calificar(nota: Double) {
        calificacion = nota
        println("Alumno calificado con $nota")
    }
}
