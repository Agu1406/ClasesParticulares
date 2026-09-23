package model

abstract class Figura {

    abstract fun calcularArea(): Double

    open fun mostrarDatos() {
        println("Area = ${calcularArea()}")
    }
}
