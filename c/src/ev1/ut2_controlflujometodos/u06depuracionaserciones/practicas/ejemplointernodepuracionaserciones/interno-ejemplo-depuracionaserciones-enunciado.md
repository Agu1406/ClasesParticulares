# Practica ejemplo: encuentra los cinco errores

**Objetivo:** Depurar leyendo las pruebas que fallan, mostrando variables y usando el depurador.

## Enunciado

El fichero contiene cinco funciones con un error cada una:

1. `suma_pares` no incluye el ultimo valor.
2. `media_enteros` hace una division entera.
3. `es_bisiesto` ignora las excepciones de los siglos.
4. `contar_cifras` falla con el numero 0.
5. `minimo3` no considera todas las combinaciones.

Para cada una: ejecuta, mira que prueba falla, **formula una hipotesis**, comprueba con `printf` o con GDB / VS Code y corrige.
No cambies las pruebas del `main`.

## Ejemplo de ejecucion

```
  [FALLO] ...
Resultado: 2/5 pruebas correctas   (antes)
Resultado: 5/5 pruebas correctas   (despues)
```

## Entrega

Entrega `EjemploDepuracionAserciones_SIN_RESOLVER.c` corregido.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
