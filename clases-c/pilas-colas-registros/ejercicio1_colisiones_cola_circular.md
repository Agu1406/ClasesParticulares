# Ejercicio 1: Resolución de Colisiones en Cola Circular

## Descripción breve de cómo resolver las colisiones cuando se implementa una cola circular utilizando arreglos

Cuando se implementa una cola circular utilizando arreglos, las colisiones ocurren cuando la cola está llena y se intenta insertar un nuevo elemento. Para resolver estas colisiones, existen varias estrategias:

### 1. **Verificación de Cola Llena**
La colisión se detecta cuando el siguiente índice después de `fin` (calculado con `(fin + 1) % tamaño`) es igual al índice `inicio`. Esto indica que la cola está completamente llena.

### 2. **Estrategias de Resolución**

#### **a) Rechazo de Inserción**
- Cuando se detecta que la cola está llena, simplemente se rechaza la inserción del nuevo elemento.
- Se muestra un mensaje de error al usuario indicando que la cola está llena.
- Esta es la estrategia más simple y común.

#### **b) Aumento del Tamaño del Arreglo**
- Si es posible, se puede crear un nuevo arreglo más grande y copiar los elementos existentes.
- Esta solución requiere reasignación de memoria y puede ser costosa computacionalmente.

#### **c) Sobrescritura (Overwrite)**
- En algunos casos específicos, se puede permitir que el nuevo elemento sobrescriba el elemento más antiguo.
- Esto convierte la cola en un buffer circular donde los elementos más antiguos se pierden.

### 3. **Implementación Típica**

La verificación de colisión se realiza antes de insertar:

```c
int siguienteFin = (fin + 1) % tamaño;
if (siguienteFin == inicio) {
    // Colisión detectada: cola llena
    // Estrategia: rechazar inserción o aplicar otra solución
    return 0; // Error: cola llena
}
```

### 4. **Prevención de Colisiones**

Para evitar colisiones, es importante:
- Mantener siempre una celda vacía entre `inicio` y `fin` para distinguir entre cola vacía y cola llena.
- Verificar el estado de la cola antes de cada operación de inserción.
- Implementar funciones auxiliares como `estaLlena()` para verificar el estado.
