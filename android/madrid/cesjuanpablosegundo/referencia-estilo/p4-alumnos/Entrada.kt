import controller.Colegio
import model.Alumno

fun main() {
    val colegio = Colegio()
    var opcion = 0
    var nextId = 1

    do {
        println("1. Matricular alumno")
        println("2. Listar alumnos")
        println("3. Listar matriculados")
        println("4. Mostrar por id")
        println("5. Desmatricular")
        println("6. Calificar")
        println("7. Salir")
        println("Introduce la opcion")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Nombre")
                val nombre = readln()
                println("Apellido")
                val apellido = readln()
                println("Telefono (enter si no tiene)")
                val telefonoRaw = readln()
                val telefono = telefonoRaw.ifBlank { null }
                println("Correo (enter si no tiene)")
                val correoRaw = readln()
                val correo = correoRaw.ifBlank { null }
                colegio.matricular(
                    Alumno(nextId, nombre, apellido, telefono, correo)
                )
                nextId++
            }

            2 -> colegio.listarAlumnos()
            3 -> colegio.listarMatriculados()
            4 -> {
                println("Id")
                colegio.mostrarPorId(readln().toInt())
            }

            5 -> {
                println("Id")
                colegio.desmatricular(readln().toInt())
            }

            6 -> {
                println("Id")
                val id = readln().toInt()
                println("Nota")
                val nota = readln().toDouble()
                colegio.calificar(id, nota)
            }

            7 -> println("Saliendo")
            else -> println("Opcion no valida")
        }
    } while (opcion != 7)
}
