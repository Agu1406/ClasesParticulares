# Ejercicio 4: Implementar Cola con Pila y Viceversa

## Implementar una Cola utilizando los Conceptos de Pila

Para implementar una cola usando dos pilas, se utilizan dos pilas auxiliares que trabajan en conjunto:

### **Estructura**
- **Pila 1 (Pila de Entrada)**: Almacena los elementos que se agregan a la cola.
- **Pila 2 (Pila de Salida)**: Almacena los elementos en orden inverso para poder extraerlos en orden FIFO.

### **Operación Encolar (Enqueue)**
1. Simplemente se hace `push` del elemento en la **Pila de Entrada**.
2. Complejidad: O(1) - tiempo constante.

### **Operación Desencolar (Dequeue)**
1. Si la **Pila de Salida** está vacía:
   - Se transfieren todos los elementos de la **Pila de Entrada** a la **Pila de Salida** (haciendo `pop` de una y `push` en la otra).
   - Esto invierte el orden, colocando el elemento más antiguo en el tope de la Pila de Salida.
2. Se hace `pop` de la **Pila de Salida** y se retorna ese elemento.
3. Complejidad: O(1) amortizado (aunque ocasionalmente puede ser O(n) cuando se transfieren elementos).

### **Ventajas**
- Utiliza solo estructuras de pila existentes.
- Implementación relativamente simple.

### **Desventajas**
- Requiere dos estructuras de datos.
- La operación de desencolar puede ser costosa ocasionalmente.

### **Ejemplo de Código Conceptual**
```
Encolar(elemento):
    push(pilaEntrada, elemento)

Desencolar():
    si estaVacia(pilaSalida):
        mientras no estaVacia(pilaEntrada):
            push(pilaSalida, pop(pilaEntrada))
    retornar pop(pilaSalida)
```

---

## Implementar una Pila utilizando los Conceptos de Cola

Para implementar una pila usando dos colas, se utilizan dos colas auxiliares:

### **Estructura**
- **Cola Principal**: Almacena los elementos de la pila.
- **Cola Auxiliar**: Se usa temporalmente durante las operaciones.

### **Operación Push (Insertar)**
1. Se encola el nuevo elemento en la **Cola Principal**.
2. Complejidad: O(1) - tiempo constante.

### **Operación Pop (Eliminar)**
1. Se transfieren todos los elementos excepto el último de la **Cola Principal** a la **Cola Auxiliar**.
2. Se desencola y retorna el último elemento de la **Cola Principal**.
3. Se intercambian los nombres de las colas (la auxiliar se convierte en la principal).
4. Complejidad: O(n) - tiempo lineal, donde n es el número de elementos.

### **Operación Top (Ver Tope)**
1. Similar a `pop`, pero se retorna el elemento sin eliminarlo.
2. Se deben transferir todos los elementos de vuelta a la cola principal.
3. Complejidad: O(n) - tiempo lineal.

### **Ventajas**
- Utiliza solo estructuras de cola existentes.
- Conceptualmente simple de entender.

### **Desventajas**
- Las operaciones `pop` y `top` son muy costosas (O(n)).
- Requiere dos estructuras de datos.
- No es eficiente para aplicaciones que requieren muchas operaciones de pila.

### **Ejemplo de Código Conceptual**
```
Push(elemento):
    encolar(colaPrincipal, elemento)

Pop():
    mientras tamanio(colaPrincipal) > 1:
        encolar(colaAuxiliar, desencolar(colaPrincipal))
    elemento = desencolar(colaPrincipal)
    intercambiar(colaPrincipal, colaAuxiliar)
    retornar elemento

Top():
    mientras tamanio(colaPrincipal) > 1:
        encolar(colaAuxiliar, desencolar(colaPrincipal))
    elemento = desencolar(colaPrincipal)
    encolar(colaAuxiliar, elemento)
    intercambiar(colaPrincipal, colaAuxiliar)
    retornar elemento
```

---

## Comparación y Conclusión

### **Cola con Pila**
- **Eficiencia**: Buena (O(1) amortizado para desencolar).
- **Uso práctico**: Más común y eficiente.
- **Recomendación**: Es una solución viable si solo se tienen pilas disponibles.

### **Pila con Cola**
- **Eficiencia**: Baja (O(n) para pop y top).
- **Uso práctico**: Principalmente académico, para demostrar conceptos.
- **Recomendación**: No es recomendable para aplicaciones reales debido a su ineficiencia.

### **Conclusión**
Aunque es posible implementar una estructura usando otra, cada estructura está optimizada para su propósito específico. La implementación de cola con pilas es más práctica que la implementación de pila con colas, pero en ambos casos es preferible usar la estructura nativa cuando sea posible.

