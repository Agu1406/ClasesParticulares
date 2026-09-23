import controller.GestorFiguras
import model.Circulo
import model.Rectangulo
import model.Triangulo

fun main() {
    val gestor = GestorFiguras()
    var opcion = 0

    do {
        println("1. Registrar circulo")
        println("2. Registrar rectangulo")
        println("3. Registrar triangulo")
        println("4. Listar figuras")
        println("5. Area total")
        println("6. Salir")
        println("Introduce la opcion")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Radio")
                val radio = readln().toDouble()
                gestor.registrarFigura(Circulo(radio))
            }

            2 -> {
                println("Base")
                val base = readln().toDouble()
                println("Altura")
                val altura = readln().toDouble()
                gestor.registrarFigura(Rectangulo(base, altura))
            }

            3 -> {
                println("Base")
                val base = readln().toDouble()
                println("Altura")
                val altura = readln().toDouble()
                gestor.registrarFigura(Triangulo(base, altura))
            }

            4 -> gestor.listarFiguras()
            5 -> println("Area total = ${gestor.areaTotal()}")
            6 -> println("Saliendo")
            else -> println("Opcion no valida")
        }
    } while (opcion != 6)
}
