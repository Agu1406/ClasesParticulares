# Ejercicio 1.1
Tenemos que crear 3 archivos de texto ("txt") en la ruta  "~/escritorio/Pruebas" usando "touch" de preferencia, se deben crear los archivos con estos nombres:

- archivo1.txt
- archivo2.txt
- archivo3.txt

# Ejercicio 1.2 - Guardar información en el archivo 1.
En el archivo "archivo1.txt" tenemos que guardar la informacion de nuestras tarjetas de red, para ello usando el comando "ifconfig". 

# Ejercicio 1.3 - Guardar información en el archivo 2.
En el archivo "archivo2.txt" tenemos que guardar el texto "Hola Mundo :)" usando el comando echo.

# Ejercicio 1.4 - No modificar el archivo 3.
El el archivo "archivo3.txt" dejadlo vacío, es decir, si ya está creado, no hace falta modificar nada más.

# Ejercicio 1.5 - Comprobar el contenido de los 3 archivos.
Ahora tenemos que comprobar la siguiente información de los 3 archivos: 
1. Si el archivo está vacío: Si está vacío tenemos que moverlo al siguiente directorio: **"~/Escritorio/Pruevas/Vacios".**
2. Si no está vacío: Tenemos que imprimir/sacar por pantalla el contenido del archivo con el siguiente mensaje incluido: **"El archivo X no está vacío y su contenido es: " (Aquí el contenido)**

Es decir, existen diferentes escenarios:

- **Archivo existe pero está vacío:** Lo movemos al directorio `vacios` dentro de `pruebas`.
- **Archivo existe y no está vacío:** Imprimimos un mensaje con el contenido del archivo.

# Ejercicio 1.6

Finalmente, como esto es un script, tenemos que mostrar por pantalla la estructura del directorio **"~/escritorio/pruebas"** y además también tenemos que mostrar un mensaje con el siguiente contenido **"La ejecución del script ha terminado a las: hora:minuto"**.