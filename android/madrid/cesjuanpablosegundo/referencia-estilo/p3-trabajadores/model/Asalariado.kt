package model

class Asalariado(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Double,
    var numeroPagas: Int,
    var contratado: Boolean,
    var cuotaSS: Double
) : Trabajador(nombre, apellido, dni, sueldo) {

    override fun calcularSalarioMensual(): Double {
        // salario quitando el 21% dividido entre el numero de pagas
        val netoAnual = sueldo * 0.79
        return netoAnual / numeroPagas
    }

    override fun mostrarDatos() {
        println("Tipo = Asalariado")
        super.mostrarDatos()
        println("numeroPagas = $numeroPagas")
        println("contratado = $contratado")
        println("cuotaSS = $cuotaSS")
    }
}
