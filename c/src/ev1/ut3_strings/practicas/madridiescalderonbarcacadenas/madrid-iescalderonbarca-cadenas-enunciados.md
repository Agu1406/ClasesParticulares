# Ejercicios de cadenas (IES Calderon de la Barca, Madrid)

Cinco ejercicios de funciones sobre cadenas. En Java devuelven un `String`; en C la
funcion recibe un **buffer de salida** con su capacidad (`char *salida, size_t capacidad`)
porque una funcion no puede devolver un array local.

| N. | Funcion | Enunciado |
|----|---------|-----------|
| 16 | `quita_caracter` | Recibe una cadena y un caracter. Devuelve la cadena sin ninguna aparicion de ese caracter. |
| 17 | `oculta_vocales` | Cambia todas las vocales **sin tilde** (mayusculas y minusculas) por el caracter `X`. |
| 18 | `quita_tildes` | Cambia las vocales con tilde (y la u con dieresis) por la misma vocal sin tilde. |
| 19 | `acorta_cadena` | Deja un caracter por cada tres (posiciones 0, 3, 6, ...) del texto original. |
| 20 | `escalera_cadena` | Alterna mayusculas y minusculas entre las letras: la primera en mayuscula, la segunda en minuscula... Los espacios y signos no cuentan para la alternancia. |

## Reglas

- Siempre se debe terminar la cadena de salida con `'\0'` y respetar `capacidad`.
- Los ficheros de este repositorio son solo ASCII: las letras con tilde se escriben con
  secuencias UTF-8 (por ejemplo `\xC3\xA9` es la e con tilde). Mira la teoria `U08_CadenasYUtf8.c`.
- Cada fichero `_SIN_RESOLVER.c` tiene las funciones por completar y las pruebas hechas.
  Al ejecutarlo debe mostrar `Resultado: N/N pruebas correctas`.

## Casos de prueba orientativos

- `quita_caracter("Hola mundo", 'o')` -> `Hla mund`
- `oculta_vocales("Hola mundo")` -> `HXlX mXndX`
- `quita_tildes("Jos\xC3\xA9 Mar\xC3\xAD" "a")` -> `Jose Maria`
- `acorta_cadena("Hola mundo")` -> `Hauo`
- `escalera_cadena("Hola mundo")` -> `HoLa MuNdO`
