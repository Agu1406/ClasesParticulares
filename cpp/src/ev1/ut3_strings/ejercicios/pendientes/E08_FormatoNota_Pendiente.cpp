/*
OBJETIVO: Lee nombre y nota; muestra un mensaje formateado con cout (no hay f-strings).
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    string opcion;

    do {
        cout << "=== E08 Formato y nota (pendiente) ===" << endl;
        cout << "1. Intentar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1") {
            cout << "Nombre del alumno: ";
            string nombre;
            getline(cin, nombre);
            cout << "Nota (0-10): ";
            string entradaNota;
            getline(cin, entradaNota);

            cout << "Instrucciones:" << endl;
            cout << "- Convierte la nota a entero (stoi o stringstream)." << endl;
            cout << "- Muestra el resultado con cout << (no hay interpolacion $ ni f-strings)." << endl;

            int nota = 0;

            // TODO: convierte entradaNota a numero y muestra un mensaje con cout.

            cout << "Ejercicio preparado para completar." << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: practicar el formato de cadenas con cout, nombre y nota." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
