import controller.Centralita
import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial

fun main() {
    val centralita = Centralita()
    var opcion = 0

    do {
        println("1. Registrar llamada local")
        println("2. Registrar llamada provincial")
        println("3. Registrar llamada nacional")
        println("4. Mostrar llamadas")
        println("5. Mostrar costes totales")
        println("6. Salir")
        println("Introduce la opcion")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Numero origen")
                val origen = readln()
                println("Numero destino")
                val destino = readln()
                println("Duracion en segundos")
                val duracion = readln().toInt()
                centralita.registrarLlamada(LlamadaLocal(origen, destino, duracion))
            }

            2 -> {
                println("Numero origen")
                val origen = readln()
                println("Numero destino")
                val destino = readln()
                println("Duracion en segundos")
                val duracion = readln().toInt()
                centralita.registrarLlamada(LlamadaProvincial(origen, destino, duracion))
            }

            3 -> {
                println("Numero origen")
                val origen = readln()
                println("Numero destino")
                val destino = readln()
                println("Duracion en segundos")
                val duracion = readln().toInt()
                println("Franja (1, 2 o 3)")
                val franja = readln().toInt()
                centralita.registrarLlamada(LlamadaNacional(origen, destino, duracion, franja))
            }

            4 -> centralita.mostrarLlamadas()
            5 -> centralita.mostrarCostesTotales()
            6 -> println("Saliendo")
            else -> println("Opcion no valida")
        }
    } while (opcion != 6)
}
