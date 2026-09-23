import controller.Empresa
import model.Asalariado
import model.Autonomo
import model.Jefe

fun main() {
    val empresa = Empresa()
    var opcion = 0

    do {
        println("1. Registrar asalariado")
        println("2. Registrar autonomo")
        println("3. Registrar jefe")
        println("4. Listar todos")
        println("5. Listar asalariados")
        println("6. Listar autonomos")
        println("7. Mostrar por DNI")
        println("8. Despedir trabajador")
        println("9. Salir")
        println("Introduce la opcion")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Nombre")
                val nombre = readln()
                println("Apellido")
                val apellido = readln()
                println("DNI")
                val dni = readln()
                println("Sueldo")
                val sueldo = readln().toDouble()
                println("Numero de pagas")
                val pagas = readln().toInt()
                println("Cuota SS")
                val cuota = readln().toDouble()
                empresa.registrarTrabajador(
                    Asalariado(nombre, apellido, dni, sueldo, pagas, true, cuota)
                )
            }

            2 -> {
                println("Nombre")
                val nombre = readln()
                println("Apellido")
                val apellido = readln()
                println("DNI")
                val dni = readln()
                println("Sueldo")
                val sueldo = readln().toDouble()
                println("Cuota SS")
                val cuota = readln().toDouble()
                empresa.registrarTrabajador(
                    Autonomo(nombre, apellido, dni, sueldo, true, cuota)
                )
            }

            3 -> {
                println("Nombre")
                val nombre = readln()
                println("Apellido")
                val apellido = readln()
                println("DNI")
                val dni = readln()
                println("Sueldo")
                val sueldo = readln().toDouble()
                println("Acciones")
                val acciones = readln().toInt()
                println("Beneficio")
                val beneficio = readln().toDouble()
                empresa.registrarTrabajador(
                    Jefe(nombre, apellido, dni, sueldo, acciones, beneficio)
                )
            }

            4 -> empresa.listarTodos()
            5 -> empresa.listarAsalariados()
            6 -> empresa.listarAutonomos()
            7 -> {
                println("DNI")
                empresa.mostrarPorDni(readln())
            }

            8 -> {
                println("DNI del jefe")
                val dniJefe = readln()
                println("DNI del trabajador a despedir")
                val dniTrabajador = readln()
                empresa.despedirTrabajador(dniJefe, dniTrabajador)
            }

            9 -> println("Saliendo")
            else -> println("Opcion no valida")
        }
    } while (opcion != 9)
}
