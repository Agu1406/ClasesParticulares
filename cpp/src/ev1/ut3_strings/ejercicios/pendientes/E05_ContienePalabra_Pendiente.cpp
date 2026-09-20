/*
OBJETIVO: find (Contains), compare al inicio (StartsWith) y al final (EndsWith).
          (Python: in + startswith/endswith). Menu do-while, 0 = salir.

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
        cout << "=== E05 Contains / StartsWith / EndsWith (pendiente) ===" << endl;
        cout << "1. Contains (contiene palabra)" << endl;
        cout << "2. StartsWith (empieza por)" << endl;
        cout << "3. EndsWith (termina en)" << endl;
        cout << "4. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1") {
            cout << "Frase: ";
            string frase;
            getline(cin, frase);
            cout << "Palabra a buscar: ";
            string palabra;
            getline(cin, palabra);
            bool contiene = false;
            // TODO: contiene = frase.find(palabra) != string::npos;
            cout << boolalpha;
            cout << "Contains: " << contiene << endl;
        } else if (opcion == "2") {
            cout << "Texto: ";
            string textoIni;
            getline(cin, textoIni);
            cout << "Prefijo: ";
            string prefijo;
            getline(cin, prefijo);
            bool empieza = false;
            // TODO: empieza = textoIni.size() >= prefijo.size()
            //       && textoIni.compare(0, prefijo.size(), prefijo) == 0;
            cout << boolalpha;
            cout << "StartsWith: " << empieza << endl;
        } else if (opcion == "3") {
            cout << "Nombre de archivo: ";
            string archivo;
            getline(cin, archivo);
            cout << "Extension (ej. .pdf): ";
            string sufijo;
            getline(cin, sufijo);
            bool termina = false;
            // TODO: termina = archivo.size() >= sufijo.size()
            //       && archivo.compare(archivo.size() - sufijo.size(), sufijo.size(), sufijo) == 0;
            cout << boolalpha;
            cout << "EndsWith: " << termina << endl;
        } else if (opcion == "4") {
            cout << "Objetivo: find busca dentro; compare al inicio/final mira extremos." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
