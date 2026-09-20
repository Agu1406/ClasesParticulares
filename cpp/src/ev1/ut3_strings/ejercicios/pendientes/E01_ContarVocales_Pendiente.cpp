/*
OBJETIVO: Lee una cadena por teclado y cuenta cuantas vocales (a, e, i, o, u) contiene.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
    string opcion;

    do {
        cout << "=== E01 Contar vocales (pendiente) ===" << endl;
        cout << "1. Intentar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);

            cout << "Instrucciones:" << endl;
            cout << "- Recorre la cadena caracter a caracter con un for y size()." << endl;
            cout << "- Convierte cada letra a minusculas con tolower si lo necesitas." << endl;
            cout << "- Suma 1 cuando encuentres a, e, i, o o u." << endl;

            int contador = 0;

            // TODO: completa el bucle para contar las vocales.
            // for (size_t i = 0; i < texto.size(); i++)
            // {
            //     char letra = tolower(texto[i]);
            //     if (...)
            //     {
            //         contador++;
            //     }
            // }

            cout << "Vocales encontradas: " << contador << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: contar cuantas vocales hay en una cadena leida con getline." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
