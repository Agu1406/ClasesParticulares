package controller

import model.Figura

class GestorFiguras {

    lateinit var figuras: ArrayList<Figura>

    init {
        figuras = arrayListOf()
    }

    fun registrarFigura(figura: Figura) {
        figuras.add(figura)
        println("Figura registrada")
        figura.mostrarDatos()
    }

    fun listarFiguras() {
        if (figuras.isEmpty()) {
            println("No hay figuras registradas")
            return
        }
        figuras.forEach { it.mostrarDatos() }
    }

    fun areaTotal(): Double {
        var total = 0.0
        figuras.forEach { total += it.calcularArea() }
        return total
    }
}
