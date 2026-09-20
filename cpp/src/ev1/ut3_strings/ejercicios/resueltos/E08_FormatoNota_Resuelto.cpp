/*
OBJETIVO: Lee nombre y nota; muestra un mensaje formateado con cout (no hay f-strings).
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
    string opcion;

    do {
        cout << "=== E08 Formato y nota (resuelto) ===" << endl;
        cout << "1. Mostrar nota" << endl;
        cout << "2. Mostrar nota y valoracion" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Nombre del alumno: ";
            string nombre;
            getline(cin, nombre);
            cout << "Nota (0-10): ";
            string entradaNota;
            getline(cin, entradaNota);

            int nota = 0;
            stringstream ss(entradaNota);
            if (!(ss >> nota)) {
                cout << "La nota debe ser un numero entero." << endl;
            } else {
                cout << nombre << " ha obtenido una nota de " << nota << "." << endl;

                if (opcion == "2") {
                    string valoracion;
                    if (nota >= 5) {
                        valoracion = "apto";
                    } else {
                        valoracion = "no apto";
                    }
                    cout << nombre << " esta " << valoracion << "." << endl;
                }
            }
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
