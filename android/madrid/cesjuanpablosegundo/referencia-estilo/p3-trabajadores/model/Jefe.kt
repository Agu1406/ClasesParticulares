package model

class Jefe(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Double,
    var acciones: Int,
    var beneficio: Double
) : Trabajador(nombre, apellido, dni, sueldo) {

    override fun calcularSalarioMensual(): Double {
        return sueldo / 12
    }

    override fun mostrarDatos() {
        println("Tipo = Jefe")
        super.mostrarDatos()
        println("acciones = $acciones")
        println("beneficio = $beneficio")
    }
}
