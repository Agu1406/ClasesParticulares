package model

class Triangulo(var base: Double, var altura: Double) : Figura() {

    override fun calcularArea(): Double {
        return (base * altura) / 2
    }

    override fun mostrarDatos() {
        println("Tipo = Triangulo")
        println("Base = $base")
        println("Altura = $altura")
        super.mostrarDatos()
    }
}
