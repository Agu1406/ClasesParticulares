# Practica interna: excepciones (menu consola)

**Carpeta:** `ejemplointernoexcepciones`  
**Enunciado:** `interno-ejemplo-excepciones-enunciado.md`

## Objetivo

Repasar `try` / `catch` / `finally`, `NumberFormatException`, `IllegalArgumentException` y validacion de negocio, uniendo UT3 (`parseInt`), division con reglas y una `Cuenta` al estilo de POO basica.

## Requisitos

Programa con menu `do-while`:

1. **Dividir con reglas** — pedir dos enteros por teclado (`Scanner` + `nextLine` + `Integer.parseInt`). Metodo `dividirConReglas(int, int)` que lance `IllegalArgumentException` si:
   - el divisor es 0
   - el dividendo es &lt;= 0
   - el dividendo es &lt;= 100  
   Mostrar el resultado si todo va bien. Capturar `NumberFormatException` e `IllegalArgumentException`.
2. **Retirar de cuenta** — `Cuenta` con titular y saldo; metodo `retirar(double)` que lance `IllegalArgumentException` si el importe &lt;= 0 o no hay saldo. Capturar el error y mostrar mensaje.
0. **Salir**

En ambas opciones usar `finally` para imprimir un mensaje del estilo «operacion cerrada».

## Entrega

Completar `EjemploExcepciones_SIN_RESOLVER.java` (ver solucion de referencia en `EjemploExcepciones_RESUELTO.java`).
