/*
OBJETIVO: find (Contains), compare al inicio (StartsWith) y al final (EndsWith).
SOLUCION: ver codigo. Menu do-while, 0 = salir.

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
        cout << "=== E05 Contains / StartsWith / EndsWith (resuelto) ===" << endl;
        cout << "1. Contains (contiene palabra)" << endl;
        cout << "2. StartsWith (empieza por)" << endl;
        cout << "3. EndsWith (termina en)" << endl;
        cout << "4. Ejemplo Python: informatica empieza por \"info\"" << endl;
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
            if (frase.find(palabra) != string::npos) {
                cout << "Si contiene la palabra." << endl;
            } else {
                cout << "No contiene la palabra." << endl;
            }
        } else if (opcion == "2") {
            cout << "Texto: ";
            string textoIni;
            getline(cin, textoIni);
            cout << "Prefijo: ";
            string prefijo;
            getline(cin, prefijo);
            bool empieza = textoIni.size() >= prefijo.size()
                && textoIni.compare(0, prefijo.size(), prefijo) == 0;
            if (empieza) {
                cout << "Si empieza por ese prefijo." << endl;
            } else {
                cout << "No empieza por ese prefijo." << endl;
            }
        } else if (opcion == "3") {
            cout << "Nombre de archivo: ";
            string archivo;
            getline(cin, archivo);
            cout << "Extension (ej. .pdf): ";
            string sufijo;
            getline(cin, sufijo);
            bool termina = archivo.size() >= sufijo.size()
                && archivo.compare(archivo.size() - sufijo.size(), sufijo.size(), sufijo) == 0;
            if (termina) {
                cout << "Si termina en ese sufijo." << endl;
            } else {
                cout << "No termina en ese sufijo." << endl;
            }
        } else if (opcion == "4") {
            string t = "informatica";
            string p = "info";
            bool empieza = t.size() >= p.size() && t.compare(0, p.size(), p) == 0;
            cout << boolalpha;
            cout << "\"" << t << "\" empieza por \"info\" = " << empieza << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
