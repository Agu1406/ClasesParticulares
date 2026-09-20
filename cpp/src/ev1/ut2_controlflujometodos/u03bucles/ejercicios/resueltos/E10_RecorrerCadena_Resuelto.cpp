/*
OBJETIVO: For: recorre cada char de un string e imprimelo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    string texto = "Hola";
    for (size_t i = 0; i < texto.size(); i++)
    {
        cout << texto[i] << endl;
    }
    return 0;
}
