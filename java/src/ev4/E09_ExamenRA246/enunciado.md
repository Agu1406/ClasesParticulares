# E09 — Examen práctico (2.ª evaluación)

**Módulo:** 0485 Programación · Consola Java  
**Duración:** 2 horas · **Total:** 10 puntos  
**RA (alumno):** RA2 · RA4 (clases, objetos, herencia) · RA6.1 (arrays)

Estilo inspirado en un examen práctico público de 2.ª eval (ver `FUENTES.md`). Enunciado adaptado para este repo.

## Instrucciones

1. Duración: 2 horas. Hay **4 ejercicios**; la puntuación va junto a cada título.
2. Cada ejercicio es un programa completo con clase `Main`. Lee con `Scanner` **en el orden indicado** y muestra la salida **exactamente** como en los ejemplos (se corrige línea a línea).
3. Entra lo de la 1.ª evaluación más arrays, `String`, clases y objetos, y herencia. En los ejercicios de clases, escribe las clases **en el mismo archivo**, **sin `public`**, antes o después de `Main`.
4. Un programa que no compila no puntúa. Entrega aunque no hayas terminado.
5. En el simulacro: sin apuntes ni Internet hasta entregar.

| Ejercicio | Puntos |
|-----------|--------|
| 1. Las notas del grupo | 2 |
| 2. La contraseña segura | 2,5 |
| 3. La cuenta del banco | 2,5 |
| 4. Las nóminas de la empresa | 3 |
| **Total** | **10** |

---

## E01_NotasGrupo (2 puntos)

Al terminar la evaluación, la tutora quiere un resumen de las notas de su grupo: la media, la nota más alta y la más baja, cuántos alumnos han quedado por encima de la media y todas las notas de menor a mayor.

### Qué debe hacer el programa

1. Lee el número de alumnos `n` y, después, `n` notas enteras de 0 a 10. Guárdalas en un array.
2. Si `n` es 0, muestra `Sin notas`.
3. Si no, muestra cinco líneas:
   - `Media: ` con un decimal (`Locale.US`)
   - `Máxima: `
   - `Mínima: `
   - `Por encima de la media: ` (estrictamente mayor)
   - `Ordenadas: ` con las notas separadas por espacios

### Ejemplos

```text
5
7
3
9
6
5
```

```text
Media: 6.0
Máxima: 9
Mínima: 3
Por encima de la media: 2
Ordenadas: 3 5 6 7 9
```

```text
0
```

```text
Sin notas
```

---

## E02_ContrasenaSegura (2,5 puntos)

El formulario de registro comprueba la contraseña antes de aceptarla. Es segura si tiene al menos 8 caracteres, alguna mayúscula, alguna minúscula, algún número y ningún espacio.

Si no lo es, el formulario explica qué le falta, regla por regla.

### Qué debe hacer el programa

1. Lee la contraseña con `nextLine` (puede tener espacios).
2. Si cumple todas las reglas, muestra `Contraseña segura`.
3. Si no, muestra `Contraseña débil:` y, **en este orden**, una línea por cada regla que no cumple:
   - `- Tiene menos de 8 caracteres`
   - `- Le falta una mayúscula`
   - `- Le falta una minúscula`
   - `- Le falta un número`
   - `- Tiene espacios`
4. Recorre la contraseña con `charAt` y usa métodos de `Character`.

### Ejemplos

```text
Hola1234
```

```text
Contraseña segura
```

```text
hola mundo
```

```text
Contraseña débil:
- Le falta una mayúscula
- Le falta un número
- Tiene espacios
```

---

## E03_CuentaBanco (2,5 puntos)

Prototipo de cuentas bancarias. Escribe una clase `Cuenta` con el titular y el saldo (privados), un constructor que recibe el titular y deja el saldo a 0, y los métodos `void ingresar(double cantidad)`, `boolean retirar(double cantidad)` (devuelve `false` y no hace nada si no hay saldo suficiente) y `toString()`.

El programa principal recibe las operaciones de un día y las aplica sobre una cuenta.

### Qué debe hacer el programa

1. Lee el titular con `nextLine` y, después, operaciones hasta `FIN`: `I 100` para ingresar y `R 30` para retirar (cantidades con `Locale.US`).
2. Si la cantidad no es mayor que 0, muestra `Cantidad no válida`.
3. Si no, muestra `Ingreso: 100.00 €`, `Retirada: 30.00 €` o, si no hay saldo, `Saldo insuficiente: quedan 70.00 €`.
4. Al llegar a `FIN`, muestra la cuenta con su `toString`: `Ana López: 70.00 €`.

### Ejemplo

```text
Ana López
I 100
R 30
R 500
FIN
```

```text
Ingreso: 100.00 €
Retirada: 30.00 €
Saldo insuficiente: quedan 70.00 €
Ana López: 70.00 €
```

---

## E04_NominasEmpresa (3 puntos)

La empresa tiene tres tipos de empleados:

- **Fijo:** cobra su sueldo base.
- **Por horas:** cada hora a su precio; a partir de la hora 160 del mes, las horas extra a 1,5 veces el precio.
- **Comercial:** sueldo base más un 5 % de lo vendido.

Escribe una clase abstracta `Empleado` con el nombre, un método abstracto `double salario()` y otro `String tipo()`, y una subclase por tipo. El programa guarda todos en un array de `Empleado` (polimorfismo).

### Qué debe hacer el programa

1. Lee el número de empleados `n` y, después, `n` líneas: `F Ana 1500`, `H Luis 170 10` o `C Eva 1200 8000`. Los nombres son de una palabra; los números, con `Locale.US`.
2. Muestra una línea por empleado: `Ana (fijo): 1500.00 €`, con el tipo `fijo`, `por horas` o `comercial`.
3. Termina con `Total: ` (suma de salarios) y `Mayor salario: ` (nombre del que más cobra; el primero si hay empate).

### Ejemplo

```text
3
F Ana 1500
H Luis 170 10
C Eva 1200 8000
```

```text
Ana (fijo): 1500.00 €
Luis (por horas): 1750.00 €
Eva (comercial): 1600.00 €
Total: 4850.00 €
Mayor salario: Luis
```

*(Luis: 160 h × 10 + 10 h extra × 15 = 1600 + 150 = 1750. Eva: 1200 + 5 % de 8000 = 1600.)*
