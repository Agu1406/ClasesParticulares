package model

import kotlin.math.PI

class Circulo(var radio: Double) : Figura() {

    fun calcularDiametro(): Double {
        return 2 * radio
    }

    override fun calcularArea(): Double {
        return PI * radio * radio
    }

    override fun mostrarDatos() {
        println("Tipo = Circulo")
        println("Radio = $radio")
        println("Diametro = ${calcularDiametro()}")
        super.mostrarDatos()
    }
}
