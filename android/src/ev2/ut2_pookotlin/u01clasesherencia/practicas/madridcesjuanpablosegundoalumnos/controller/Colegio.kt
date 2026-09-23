package controller

import model.Alumno

class Colegio {

    lateinit var alumnos: ArrayList<Alumno>

    init {
        alumnos = arrayListOf()
    }

    fun matricular(alumno: Alumno) {
        val existe = alumnos.find { it.id == alumno.id }
        if (existe != null) {
            println("Ya existe un alumno con ese id")
            return
        }
        alumnos.add(alumno)
        println("Alumno matriculado")
        alumno.mostrarDatos()
    }

    fun listarAlumnos() {
        if (alumnos.isEmpty()) {
            println("No hay alumnos")
            return
        }
        alumnos.forEach { it.mostrarDatos() }
    }

    fun listarMatriculados() {
        alumnos.forEach {
            if (it.matriculado) {
                it.mostrarDatos()
            }
        }
    }

    fun mostrarPorId(id: Int) {
        val alumno = alumnos.find { it.id == id }
        if (alumno == null) {
            println("No se ha encontrado el alumno")
        } else {
            alumno.mostrarDatos()
        }
    }

    fun desmatricular(id: Int) {
        val alumno = alumnos.find { it.id == id }
        if (alumno == null) {
            println("No se ha encontrado el alumno")
        } else {
            alumno.desmatricular()
        }
    }

    fun calificar(id: Int, nota: Double) {
        val alumno = alumnos.find { it.id == id }
        if (alumno == null) {
            println("No se ha encontrado el alumno")
        } else {
            alumno.calificar(nota)
        }
    }
}
