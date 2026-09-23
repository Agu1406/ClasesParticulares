import controller.GestoraFestival
import model.DJ
import model.Escenario
import model.Grupo
import model.Solista

fun main() {
    val gestora = GestoraFestival()
    var opcion = 0

    do {
        println("1. registrarArtista")
        println("2. registrarEscenario")
        println("3. programarActuacion")
        println("4. buscarArtistasPorPais")
        println("5. obtenerArtistaMasCaro")
        println("6. obtenerCostesTotales")
        println("7. mostrarActuaciones")
        println("8. Salir")
        println("Introduce la opcion")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Tipo 1 Solista 2 Grupo 3 DJ")
                val tipo = readln().toInt()
                println("Id")
                val id = readln().toInt()
                println("Nombre")
                val nombre = readln()
                println("Pais")
                val pais = readln()
                when (tipo) {
                    1 -> {
                        println("Numero de discos")
                        val discos = readln().toInt()
                        println("Instrumento")
                        val instrumento = readln()
                        gestora.registrarArtista(Solista(id, nombre, pais, discos, instrumento))
                    }
                    2 -> {
                        println("Numero de componentes")
                        val componentes = readln().toInt()
                        println("Genero")
                        val genero = readln()
                        gestora.registrarArtista(Grupo(id, nombre, pais, componentes, genero))
                    }
                    3 -> {
                        println("Horas de sesion")
                        val horas = readln().toInt()
                        println("Internacional s/n")
                        val internacional = readln().equals("s", true)
                        gestora.registrarArtista(DJ(id, nombre, pais, horas, internacional))
                    }
                    else -> println("Tipo no valido")
                }
            }
            2 -> {
                println("Id")
                val id = readln().toInt()
                println("Nombre")
                val nombre = readln()
                println("Capacidad")
                val capacidad = readln().toInt()
                gestora.registrarEscenario(Escenario(id, nombre, capacidad))
            }
            3 -> {
                println("Id actuacion")
                val idAct = readln().toInt()
                println("Id artista")
                val idArt = readln().toInt()
                println("Id escenario")
                val idEsc = readln().toInt()
                println("Duracion")
                val duracion = readln().toInt()
                println("Hora inicio")
                val horaInicio = readln().toInt()
                gestora.programarActuacion(idAct, idArt, idEsc, duracion, horaInicio)
            }
            4 -> {
                println("Pais")
                gestora.buscarArtistasPorPais(readln())
            }
            5 -> gestora.obtenerArtistaMasCaro()
            6 -> gestora.obtenerCostesTotales()
            7 -> {
                println("Id escenario")
                gestora.mostrarActuaciones(readln().toInt())
            }
            8 -> println("Saliendo")
            else -> println("Opcion no valida")
        }
    } while (opcion != 8)
}
