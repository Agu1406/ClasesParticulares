package controller

import model.Actuacion
import model.Artista
import model.Escenario

class GestoraFestival() {

    lateinit var artistas: ArrayList<Artista>
    lateinit var escenarios: ArrayList<Escenario>
    lateinit var actuaciones: ArrayList<Actuacion>

    init {
        artistas = arrayListOf()
        escenarios = arrayListOf()
        actuaciones = arrayListOf()
    }

    fun registrarArtista(artista: Artista): Unit {
        val existe: Artista? = artistas.find { it.id == artista.id }
        if (existe == null) {
            artistas.add(artista)
            println("Artista registrado")
            artista.mostrarDatos()
        } else {
            println("Ya existe un artista con ese id")
        }
    }

    fun registrarEscenario(escenario: Escenario): Unit {
        val existe: Escenario? = escenarios.find { it.id == escenario.id }
        if (existe == null) {
            escenarios.add(escenario)
            println("Escenario registrado")
            escenario.mostrarDatos()
        } else {
            println("Ya existe un escenario con ese id")
        }
    }

    fun programarActuacion(
        idActuacion: Int,
        idArtista: Int,
        idEscenario: Int,
        duracion: Int,
        horaInicio: Int
    ): Unit {
        val artista: Artista? = artistas.find { it.id == idArtista }
        val escenario: Escenario? = escenarios.find { it.id == idEscenario }

        if (artista == null) {
            println("No existe un artista con ese id")
            return
        }
        if (escenario == null) {
            println("No existe un escenario con ese id")
            return
        }

        val mismoId: Actuacion? = actuaciones.find {
            it.escenario.id == idEscenario && it.id == idActuacion
        }
        if (mismoId != null) {
            println("Ese escenario ya tiene una actuacion con ese identificador")
            return
        }

        val nueva = Actuacion(idActuacion, artista, escenario, duracion, horaInicio)

        val solape: Actuacion? = actuaciones.find {
            it.escenario.id == idEscenario && it.solapaCon(nueva)
        }
        if (solape != null) {
            println("La actuacion se solapa con otra del mismo escenario")
            return
        }

        actuaciones.add(nueva)
        println("Actuacion programada")
        nueva.mostrarDatos()
    }

    fun buscarArtistasPorPais(pais: String): Unit {
        var encontrados = 0
        artistas.forEach {
            if (it.pais.equals(pais, true)) {
                it.mostrarDatos()
                encontrados++
            }
        }
        if (encontrados == 0) {
            println("No hay artistas de ese pais")
        }
    }

    fun obtenerArtistaMasCaro(): Unit {
        if (artistas.size == 0) {
            println("No hay artistas registrados")
            return
        }
        var masCaro: Artista = artistas[0]
        artistas.forEach {
            if (it.calcularCache() > masCaro.calcularCache()) {
                masCaro = it
            }
        }
        println("Artista mas caro")
        masCaro.mostrarDatos()
    }

    fun obtenerCostesTotales(): Unit {
        var total = 0
        artistas.forEach {
            total = total + it.calcularCache()
        }
        println("Coste total cache = ${total}")
    }

    fun mostrarActuaciones(idEscenario: Int): Unit {
        val escenario: Escenario? = escenarios.find { it.id == idEscenario }
        if (escenario == null) {
            println("No existe un escenario con ese id")
            return
        }
        var encontrados = 0
        actuaciones.forEach {
            if (it.escenario.id == idEscenario) {
                it.mostrarDatos()
                encontrados++
            }
        }
        if (encontrados == 0) {
            println("No hay actuaciones en ese escenario")
        }
    }
}
