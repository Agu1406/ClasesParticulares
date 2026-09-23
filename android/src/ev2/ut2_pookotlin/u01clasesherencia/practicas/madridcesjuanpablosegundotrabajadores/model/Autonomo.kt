package model

class Autonomo(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Double,
    var contratado: Boolean,
    var cuotaSS: Double = 0.0
) : Trabajador(nombre, apellido, dni, sueldo) {

    override fun calcularSalarioMensual(): Double {
        // (sueldo - 12 * cuotaSS) / 12
        return (sueldo - (12 * cuotaSS)) / 12
    }

    override fun mostrarDatos() {
        println("Tipo = Autonomo")
        super.mostrarDatos()
        println("contratado = $contratado")
        println("cuotaSS = $cuotaSS")
    }
}
