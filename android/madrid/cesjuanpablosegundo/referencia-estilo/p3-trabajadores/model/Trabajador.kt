package model

abstract class Trabajador(
    var nombre: String,
    var apellido: String,
    val dni: String,
    var sueldo: Double
) {

    abstract fun calcularSalarioMensual(): Double

    open fun mostrarDatos() {
        println("nombre = $nombre")
        println("apellido = $apellido")
        println("dni = $dni")
        println("sueldo = $sueldo")
        println("salario mensual = ${calcularSalarioMensual()}")
    }
}
