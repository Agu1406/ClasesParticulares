package model

class Rectangulo(var base: Double, var altura: Double) : Figura() {

    fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }

    override fun calcularArea(): Double {
        return base * altura
    }

    override fun mostrarDatos() {
        println("Tipo = Rectangulo")
        println("Base = $base")
        println("Altura = $altura")
        println("Perimetro = ${calcularPerimetro()}")
        super.mostrarDatos()
    }
}
