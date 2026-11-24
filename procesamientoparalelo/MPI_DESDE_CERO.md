# MPI desde cero (para el profesor y el alumno)

Si sabes C pero **no** has tocado MPI, lee esto antes de abrir los `.c`.

## La idea en una frase

MPI no es un lenguaje. Es una **biblioteca** (`#include <mpi.h>`) para que **varios procesos** (varias copias de tu programa) **se envíen datos** (mensajes).

## Analogía que funciona en clase

Imagina que abres el **mismo** `.c` en **4 terminales a la vez**. Cada terminal es un **proceso**. No comparten variables: si en uno pones `x = 5`, los otros **no** lo ven. Para pasar el `5` hace falta un **mensaje** (`MPI_Send` / `MPI_Recv`), como un WhatsApp entre programas.

`mpirun -np 4 ./prog` = “abre 4 terminales con ese programa”.

## Palabras que salen todo el rato

| Palabra | Qué significa (junior) |
|---------|-------------------------|
| **Proceso** | Una ejecución del programa (una “terminal”) |
| **Rank / rango / `idProc`** | El número de esa ejecución: 0, 1, 2… | 
| **Size** | Cuántos procesos hay en el grupo |
| **Comunicador** | El “grupo de chat” (`MPI_COMM_WORLD` = todos los que arrancó `mpirun`) |
| **Tag** | Etiqueta del mensaje (un `int`) para no mezclar conversaciones |
| **Estático** | Proceso que nace con `mpirun -np N` (los N del principio) |
| **Dinámico / hijo** | Proceso creado **después** con `MPI_Comm_spawn` |
| **Punto a punto** | Un proceso envía a **uno** concreto (`Send`/`Recv`) |
| **Colectiva** | Participan **todos** del grupo (`Bcast`, `Reduce`…) |
| **Intercommunicador** | “Chat” entre **dos grupos** (p. ej. padres ↔ hijos) |

## Qué hace cada pieza mínima

```c
MPI_Init(&argc, &argv);   // encender MPI (obligatorio al principio)
MPI_Comm_rank(..., &id);  // ¿quién soy yo? (0, 1, 2...)
MPI_Comm_size(..., &n);   // ¿cuántos somos?
MPI_Send(...);            // envío un dato a otro rank
MPI_Recv(...);            // espero un dato de otro rank
MPI_Finalize();           // apagar MPI (obligatorio al final)
```

Sin `Init`/`Finalize`, el resto no cuenta.

## Compilar ≠ gcc normal

```bash
mpicc -Wall -o prog prog.c   # enlaza la librería MPI
mpirun -np 4 ./prog          # lanza 4 procesos
```

`gcc prog.c` **solo** suele fallar o no bastar: falta la librería MPI.

En **tu Windows** puede que no tengas `mpicc`. En la **VM UNED del alumno** sí. Clase: proyectas código aquí; ejecutas allí (o instalas MPI después).

## El truco más importante del examen UNED

Muchos enunciados dicen: *“procesos estáticos crean hijos dinámicos”*.

1. Arrancas con `mpirun -np 2` → 2 **padres** (estáticos).
2. Cada padre (o el grupo) llama `MPI_Comm_spawn` → nacen **hijos**.
3. El hijo pregunta `MPI_Comm_get_parent()`:
   - si **no** es `MPI_COMM_NULL` → **soy hijo**
   - si **es** `MPI_COMM_NULL` → **soy padre / estático**

Por eso en un **solo** `.c` suele haber:

```c
if (parent == MPI_COMM_NULL) {
    /* código del padre */
} else {
    /* código del hijo */
}
```

Mismo fichero, dos “personajes”. Eso confunde al principio: es normal.

## Orden para aprender (ambos)

1. [`src/ut1_…/U01_HolaMpi.c`](src/ut1_introduccionmpi/u01entorno/teoria/U01_HolaMpi.c) — “se ejecuta N veces”
2. Rank y size — “quién soy”
3. Send/Recv — “WhatsApp entre dos”
4. Anillo — “pasar el testigo”
5. Spawn — “nacer hijos”
6. Colectivas — “todos a una”
7. Exámenes en `ut6`

No saltes a spawn el primer día si aún no ves rank/Send.

## Errores típicos (los veréis ya)

- Esperar que una variable se “comparta” entre procesos → **no**. Hay que enviarla.
- `Recv` los dos a la vez sin nadie que haga `Send` → **deadlock** (se quedan colgados).
- Olvidar que **todos** deben llamar a las colectivas (`Bcast`, etc.).
- Confundir rank del padre con rank del hijo (cada grupo numera 0, 1, 2… por su cuenta).

## Mini glosario de funciones (solo las del examen)

| Función | Para qué |
|---------|----------|
| `MPI_Init` / `MPI_Finalize` | Encender / apagar |
| `MPI_Comm_rank` / `size` | Quién soy / cuántos somos |
| `MPI_Send` / `MPI_Recv` | Mensaje de A → B |
| `MPI_Bcast` | Uno reparte el mismo dato a todos |
| `MPI_Scatter` | Uno reparte **trozos** distintos |
| `MPI_Gather` | Todos mandan un trozo al root |
| `MPI_Reduce` | Todos aportan; el root obtiene suma/máx/… |
| `MPI_Comm_spawn` | Crear procesos hijos |
| `MPI_Comm_get_parent` | ¿Tengo padre? (soy hijo dinámico) |
| `MPI_Intercomm_merge` | Juntar padre+hijos en un solo “chat” normal |

Cuando en clase digas “no entiendo esta línea”, volved a esta tabla.
