#!/bin/bash

# Nos desplazamos al escritorio.
cd ~/Escritorio
# Creamos el directorio "Pruebas".
mkdir Pruebas
# Desde donde estamos (escritorio) nos vamos a "Pruebas".
cd ./Pruebas

# Creamos los tres archivos necesarios para el ejercicio.
touch archivo1.txt # Existe pero esta vacio.
touch archivo2.txt # Existe pero esta vacio.
touch archivo3.txt # Existe pero esta vacio.

ifconfig > archivo1.txt # Existe y no esta vacio.

echo "Hola mundo :)" > archivo2.txt # Existe y no esta vació.

# SI [ archivo1.txt existe ] haz esto...
if [ -f archivo1.txt ]; then
    # SI [ archivo1.txt tiene contenido ] haz esto...
    if [ -s archivo1.txt ]; then
            # Mensaje para mi mismo que dice que no está vacio.
            echo "El archivo1 no está vacio y su contenido es: "
            # Imprime/muestra el contenido del archivo.
            cat archivo1.txt
            
        # SINO [ tiene contenido ] hace esto...
        else
            if [ -d Vacios ]; then 
                echo "El archivo1 está vacío, lo movemos a vacios"
                mv archivo1.txt ./Vacios
                else

                # Si ya existe "vacios" MKDIR no hace nada.
                mkdir -p Vacios
                echo "El archivo1 está vacío, lo movemos a vacios"
                mv archivo1.txt ./Vacios
            fi
        fi
    fi

# SI [ archivo2.txt existe ] haz esto...
if [ -f archivo2.txt ]; then
    # SI [ archivo2.txt tiene contenido ] haz esto...
    if [ -s archivo2.txt ]; then
            # Mensaje para mi mismo que dice que no está vacio.
            echo "El archivo2 no está vacio y su contenido es: "
            # Imprime/muestra el contenido del archivo.
            cat archivo2.txt
            
        # SINO [ tiene contenido ] hace esto...
        else
            if [ -d Vacios ]; then 
                echo "El archivo2 está vacío, lo movemos a vacios"
                mv archivo2.txt ./Vacios
                else

                # Si ya existe "vacios" MKDIR no hace nada.
                mkdir -p Vacios
                echo "El archivo2 está vacío, lo movemos a vacios"
                mv archivo2.txt ./Vacios
            fi
        fi
    fi

# SI [ archivo3.txt existe ] haz esto...
if [ -f archivo3.txt ]; then
    # SI [ archivo3.txt tiene contenido ] haz esto...
    if [ -s archivo3.txt ]; then
            # Mensaje para mi mismo que dice que no está vacio.
            echo "El archivo3 no está vacio y su contenido es: "
            # Imprime/muestra el contenido del archivo.
            cat archivo3.txt
            
        # SINO [ tiene contenido ] hace esto...
        else
            if [ -d Vacios ]; then 
                echo "El archivo1 está vacío, lo movemos a vacios"
                mv archivo3.txt ./Vacios
                else

                # Si ya existe "vacios" MKDIR no hace nada.
                mkdir -p Vacios
                echo "El archivo3 está vacío, lo movemos a vacios"
                mv archivo3.txt ./Vacios
            fi
        fi
    fi

# Imprimo el arbol de directorios.
tree ~/Escritorio/Pruebas
# Imprimo mensaje final con hora de finalización.
echo "La ejecución del script ha acabado a las:" date 