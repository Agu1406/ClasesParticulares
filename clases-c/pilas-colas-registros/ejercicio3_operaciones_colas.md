# Ejercicio 3: Operaciones y Funciones de Colas

## Principales Operaciones de Colas

Las colas son estructuras de datos de tipo FIFO (First In, First Out - Primero en Entrar, Primero en Salir). Las principales operaciones son:

### 1. **Encolar (Enqueue)**
- **Descripción**: Agrega un elemento al final de la cola.
- **Parámetros**: El elemento a agregar.
- **Resultado**: El elemento se coloca en la posición `fin` de la cola.
- **Condición**: Solo se puede realizar si la cola no está llena.

### 2. **Desencolar (Dequeue)**
- **Descripción**: Elimina y retorna el elemento que está al frente de la cola.
- **Parámetros**: Ninguno (o la cola misma).
- **Resultado**: Retorna el elemento que estaba en la posición `inicio`.
- **Condición**: Solo se puede realizar si la cola no está vacía.

### 3. **Ver Frente (Front/Peek)**
- **Descripción**: Consulta el elemento que está al frente de la cola sin eliminarlo.
- **Parámetros**: Ninguno (o la cola misma).
- **Resultado**: Retorna el elemento en la posición `inicio` sin modificar la cola.
- **Condición**: Solo se puede realizar si la cola no está vacía.

### 4. **Verificar si está Vacía (isEmpty)**
- **Descripción**: Comprueba si la cola no tiene elementos.
- **Parámetros**: Ninguno (o la cola misma).
- **Resultado**: Retorna verdadero si la cola está vacía, falso en caso contrario.

### 5. **Verificar si está Llena (isFull)**
- **Descripción**: Comprueba si la cola ha alcanzado su capacidad máxima.
- **Parámetros**: Ninguno (o la cola misma).
- **Resultado**: Retorna verdadero si la cola está llena, falso en caso contrario.

## Funciones que se Utilizan para la Estructura de Colas

### Funciones Básicas de Implementación

#### **1. Función `estaVacia(int inicio, int fin)`**
- **Propósito**: Verificar si la cola está vacía.
- **Lógica**: La cola está vacía cuando `inicio == fin`.
- **Retorno**: 1 si está vacía, 0 si no lo está.

#### **2. Función `estaLlena(int inicio, int fin, int tamaño)`**
- **Propósito**: Verificar si la cola está llena.
- **Lógica**: Calcula `siguienteFin = (fin + 1) % tamaño` y verifica si `siguienteFin == inicio`.
- **Retorno**: 1 si está llena, 0 si no lo está.

#### **3. Función `encolar(cola c, int* inicio, int* fin, int elemento)`**
- **Propósito**: Agregar un elemento al final de la cola.
- **Proceso**:
  1. Verifica si la cola está llena.
  2. Si no está llena, coloca el elemento en la posición `fin`.
  3. Actualiza `fin` usando aritmética modular: `fin = (fin + 1) % tamaño`.
- **Retorno**: 1 si se agregó correctamente, 0 si falló.

#### **4. Función `desencolar(cola c, int* inicio, int* fin)`**
- **Propósito**: Eliminar y retornar el elemento del frente de la cola.
- **Proceso**:
  1. Verifica si la cola está vacía.
  2. Si no está vacía, guarda el elemento de la posición `inicio`.
  3. Actualiza `inicio` usando aritmética modular: `inicio = (inicio + 1) % tamaño`.
- **Retorno**: El elemento eliminado, o un valor especial si falló.

#### **5. Función `verFrente(cola c, int inicio)`**
- **Propósito**: Consultar el elemento del frente sin eliminarlo.
- **Proceso**: Retorna el elemento en la posición `inicio` sin modificar los índices.
- **Retorno**: El elemento del frente, o un valor especial si la cola está vacía.

### Funciones Auxiliares

#### **6. Función `inicializarCola(int* inicio, int* fin)`**
- **Propósito**: Inicializar los índices de la cola.
- **Proceso**: Establece `inicio = 0` y `fin = 0`.

#### **7. Función `tamanioCola(int inicio, int fin, int capacidad)`**
- **Propósito**: Calcular el número de elementos en la cola.
- **Lógica**: Si `fin >= inicio`, retorna `fin - inicio`. Si no, retorna `capacidad - inicio + fin`.

#### **8. Función `mostrarCola(cola c, int inicio, int fin, int capacidad)`**
- **Propósito**: Mostrar todos los elementos de la cola.
- **Proceso**: Recorre desde `inicio` hasta `fin` usando aritmética modular.

## Resumen

Las colas implementan el principio FIFO mediante dos índices (`inicio` y `fin`) y operaciones que utilizan aritmética modular para crear un comportamiento circular. Las funciones principales permiten agregar elementos al final, eliminar elementos del frente, y consultar el estado y contenido de la cola.
