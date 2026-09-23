# U02 — Control de flujo (Kotlin)

Muy parecido a Java, con matices en el `for` y en el `when` (sustituye a `switch`).

## if

```kotlin
if (comienzo) print("Comenzamos") else print("No estamos preparados")

val mensaje = if (edad >= 18) "mayor" else "menor"  // if como expresión
```

## when

```kotlin
when (opcion) {
    1 -> println("Una")
    2, 3 -> println("Dos o tres")
    in 4..10 -> println("Entre 4 y 10")
    else -> println("Otro")
}
```

También puede usarse como expresión y devolver un valor.

## for y rangos

```kotlin
for (i in 0..10) { println(i) }       // inclusive
for (i in 0 until 10) { println(i) }  // exclusive
for (i in 10 downTo 0 step 2) { }
(0 until 5).forEach { println(it) }
```

## while y do-while

```kotlin
var n = 0
while (n < 5) { n++ }

do {
    println("Introduce opcion")
    opcion = readln().toInt()
} while (opcion != 0)
```

Patrón habitual en las prácticas del CES: menú con `do/while` + `when` (centralita, figuras, trabajadores, alumnos).
