# Ejercicio 3: Resolución de Colisiones en Cola Circular

## ¿Qué es una colisión en una cola circular?

Una **colisión** ocurre cuando intentamos agregar un elemento a una cola circular que ya está **llena**. Esto sucede cuando la siguiente posición disponible (`fin + 1`) coincide con la posición de inicio (`inicio`).

## ¿Cómo detectar una colisión?

Para detectar si la cola está llena (y por tanto habrá colisión), verificamos:

```
siguienteFin = (fin + 1) % tamaño
si siguienteFin == inicio entonces
    la cola está llena → COLISIÓN
```

## Estrategias para resolver colisiones

### 1. **Rechazar la operación (Método más común)**

Cuando detectamos que la cola está llena, simplemente **rechazamos** agregar el nuevo elemento y mostramos un mensaje de error.

**Ventajas:**
- Simple de implementar
- No modifica los datos existentes
- El usuario sabe que la cola está llena

**Desventajas:**
- Se pierde el elemento que intentamos agregar
- El usuario debe esperar a que se libere espacio

**Ejemplo en código:**
```c
if (estaLlena(inicio, fin, tamaño)) {
    printf("Colisión: La cola está llena. No se puede agregar.\n");
    return 0; // Indica que no se pudo agregar
}
```

### 2. **Sobrescribir el elemento más antiguo**

Cuando la cola está llena, eliminamos el elemento más antiguo (el que está en `inicio`) y agregamos el nuevo elemento.

**Ventajas:**
- Siempre podemos agregar elementos
- Útil cuando solo nos interesan los elementos más recientes

**Desventajas:**
- Se pierden datos antiguos
- Puede no ser deseable en todas las aplicaciones

**Ejemplo conceptual:**
```
Si cola está llena:
    avanzar inicio (eliminar el más antiguo)
    agregar nuevo elemento en fin
```

### 3. **Aumentar el tamaño del arreglo**

Redimensionar dinámicamente el arreglo cuando está lleno (requiere memoria dinámica).

**Ventajas:**
- No se pierden datos
- La cola puede crecer según necesidad

**Desventajas:**
- Más complejo de implementar
- Requiere reasignación de memoria
- Puede ser costoso en términos de rendimiento

## Implementación práctica (Método 1: Rechazar)

En el ejercicio 2 (`ejercicio2_cola_bancaria.c`), la colisión se resuelve rechazando la operación:

```c
int agregarACola(cola c, int* inicio, int* fin, int numeroPersona) {
    if (estaLlena(*inicio, *fin, CAPACIDAD_MAXIMA)) {
        printf("Colision: La cola esta llena. Persona %d no puede entrar.\n", numeroPersona);
        return 0; // Retornamos 0 para indicar que no se pudo agregar
    }
    // ... resto del código para agregar
}
```

## Ejemplo visual de colisión

```
Estado inicial:
Arreglo: [1, 2, 3, 4, 5, 6, 7, 8]
         ↑                    ↑
      inicio                fin

Cola LLENA → siguienteFin = (8 + 1) % 8 = 1
Pero inicio = 0, no hay colisión todavía.

Si avanzamos fin:
Arreglo: [1, 2, 3, 4, 5, 6, 7, 8]
         ↑  ↑
      fin inicio

Ahora siguienteFin = (0 + 1) % 8 = 1
Y inicio = 1 → COLISIÓN DETECTADA
```

## Resumen

La forma más común de resolver colisiones en una cola circular es **rechazar la operación** cuando la cola está llena, informando al usuario que no hay espacio disponible. Esto mantiene la integridad de los datos y permite que el usuario tome una decisión (esperar, atender personas, etc.).

