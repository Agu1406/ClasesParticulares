# U03 — Funciones (Kotlin)

Documentación: https://kotlinlang.org/docs/functions.html

```kotlin
fun nombreFuncion() { }
```

Punto de entrada:

```kotlin
fun main(arguments: Array<String>) { }
// o simplemente:
fun main() { }
```

## Parámetros, defaults y Unit

```kotlin
fun saludar(
    nombreParam: String? = null,
    apellidoParam: String? = null,
    veces: Int = 5
): Unit {
    (0 until veces).forEachIndexed { _, index ->
        println("Saludo nº ${index + 1} : Hola ${nombreParam ?: ""} ${apellidoParam ?: ""}")
    }
}

saludar(nombreParam = "Luis", veces = 2)  // argumentos nominales
```

Si no se indica tipo de retorno, es `Unit` (equivalente a `void`).

## Retorno con tipo

```kotlin
fun resultadoOperacion(op1: Int, op2: Int): String {
    return "$op1 * $op2 = ${op1 * op2}"
}
```

Cuerpo de una sola expresión:

```kotlin
fun doble(n: Int) = n * 2
```

## Lambdas (introducción breve)

```kotlin
var sumaFlecha: (Int, Int) -> Unit = { op1, op2 -> println(op1 + op2) }
var sumaInt: (Int, Int) -> Int = { op1, op2 -> op1 + op2 }

listOf(1, 2, 3).forEach { println(it) }
```

En las prácticas se usan mucho lambdas cortas con `forEach`, `find` y `filter`.
