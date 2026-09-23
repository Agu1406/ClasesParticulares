# U01 — Variables y visibilidad (Kotlin)

Apuntes de clase (tono profesor). Documentación: https://kotlinlang.org/docs/basic-syntax.html#defining-variables

Algunas diferencias rápidas respecto a Java:

- Extensión `.kt`
- Las clases son `final` por defecto (`open` para heredar)
- No hay `static` clásico → `companion object` o funciones top-level
- Un fichero puede tener varias clases y funciones; el nombre del fichero no tiene que coincidir con la clase

## Modificadores de visibilidad

- `public` (por defecto)
- `private`
- `protected`
- `internal` (visible en el mismo módulo)

Aplican a propiedades, funciones, clases y objetos.

## Variables: `var` y `val`

```kotlin
var numero: Int = 0          // mutable
val VARIABLE_CONSTANTE = "FIJO"  // inmutable (la referencia no cambia)
```

El tipo se puede inferir. Tipos básicos habituales: `Int`, `Double`, `Boolean`, `String`, `Char`, `Long`.

## Nullability

En Kotlin el null se controla en el tipo:

```kotlin
var localidad: String? = null
lateinit var pais: String   // se inicializa más tarde (no nullable)

println(localidad ?: "sin definir")  // Elvis
println(localidad?.length)           // safe call
```

`lateinit` sirve cuando aún no tienes el valor en el constructor (muy usado con listas en controladores: `lateinit var llamadas: ArrayList<Llamada>`).

## Ejemplo mínimo

```kotlin
fun main() {
    val nombre = "Ana"
    var edad = 20
    edad++
    println("$nombre tiene $edad años")
}
```

En clase también se ve `readln()`, funciones top-level y lambdas sencillas (ver material `U01_VariablesEntrada.kt` si está en el repo).
