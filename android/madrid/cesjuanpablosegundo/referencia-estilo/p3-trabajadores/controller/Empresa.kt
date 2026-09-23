package controller

import model.Asalariado
import model.Autonomo
import model.Jefe
import model.Trabajador

class Empresa {

    lateinit var trabajadores: ArrayList<Trabajador>

    init {
        trabajadores = arrayListOf()
    }

    fun registrarTrabajador(trabajador: Trabajador) {
        val existe = trabajadores.find { it.dni.equals(trabajador.dni, true) }
        if (existe != null) {
            println("Ya existe un trabajador con ese DNI")
            return
        }
        trabajadores.add(trabajador)
        println("Trabajador registrado")
        trabajador.mostrarDatos()
    }

    fun listarTodos() {
        if (trabajadores.isEmpty()) {
            println("No hay trabajadores")
            return
        }
        trabajadores.forEach { it.mostrarDatos() }
    }

    fun listarAsalariados() {
        trabajadores.forEach {
            if (it is Asalariado) {
                it.mostrarDatos()
            }
        }
    }

    fun listarAutonomos() {
        trabajadores.forEach {
            if (it is Autonomo) {
                it.mostrarDatos()
            }
        }
    }

    fun mostrarPorDni(dni: String) {
        val trabajador = trabajadores.find { it.dni.equals(dni, true) }
        if (trabajador == null) {
            println("No se ha encontrado el trabajador")
        } else {
            trabajador.mostrarDatos()
        }
    }

    // el jefe despide: comprueba que el dni del jefe existe y es Jefe
    fun despedirTrabajador(dniJefe: String, dniTrabajador: String) {
        val jefe = trabajadores.find { it.dni.equals(dniJefe, true) }
        if (jefe == null || jefe !is Jefe) {
            println("El DNI del jefe no es correcto")
            return
        }
        val trabajador = trabajadores.find { it.dni.equals(dniTrabajador, true) }
        if (trabajador == null) {
            println("El trabajador no existe")
            return
        }
        if (trabajador is Jefe) {
            println("No se puede despedir a un jefe con esta operacion")
            return
        }
        trabajadores.remove(trabajador)
        println("Trabajador despedido por el jefe ${jefe.nombre}")
    }
}
