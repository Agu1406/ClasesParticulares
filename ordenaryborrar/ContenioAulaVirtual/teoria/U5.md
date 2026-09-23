# U05 — Clases, herencia y polimorfismo (Kotlin)

Documentación: https://kotlinlang.org/docs/classes.html

## Clase y constructores

```kotlin
class ClaseA(var nombre: String)  // constructor primario

class Lenguaje {
    var nombre: String
    var plataforma: String
    var version: Int? = null

    constructor(nombre: String, plataforma: String, version: Int) {
        this.nombre = nombre
        this.plataforma = plataforma
        this.version = version
    }

    constructor(nombre: String, plataforma: String) {
        this.nombre = nombre
        this.plataforma = plataforma
    }
}
```

## Herencia: open / override

Las clases son finales por defecto → marcar `open`. Métodos a sobrescribir → `open` / `override`.

```kotlin
open class Person(var name: String, var surname: String, val dni: String) {
    var email: String? = null

    constructor(nameS: String, surnameS: String, dniS: String, email: String)
            : this(nameS, surnameS, dniS) {
        this.email = email
    }

    open fun mostrarDatos() {
        println("name = $name")
        println("email = ${email ?: "no se ha definido email"}")
    }
}

class Student(
    name: String, surname: String, dni: String, email: String,
    var nia: Int, var mat: Int
) : Person(name, surname, dni, email) {
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nia = $nia")
    }
}
```

## Abstractas

```kotlin
abstract class Llamada(var nOrigen: String, var nDestino: String, var duracion: Int) {
    var coste: Double = 0.0
    abstract fun calcularCoste(): Double
    open fun mostrarDatos() { /* ... */ }
}
```

Las hijas (`LlamadaLocal`, `LlamadaProvincial`, `LlamadaNacional`) implementan `calcularCoste()` con fórmulas distintas → polimorfismo.

## Estilo de las prácticas CES

- Paquetes `model/` y `controller/`
- Métodos `mostrarDatos()`, menú en `Entrada`
- Listas con `ArrayList` + `lateinit` + `init`
- Prácticas: centralita, figuras, trabajadores, alumnos (y school / objetos)
