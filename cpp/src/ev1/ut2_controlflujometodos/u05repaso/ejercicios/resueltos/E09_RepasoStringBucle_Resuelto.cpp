/*
OBJETIVO: Recorrer letras de "C++" con size() e indice.
SOLUCION: ver codigo.
PATRON: Menu do-while con opcion 0 salir y uso de cin.
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu() {
    cout << endl;
    cout << "=== E09 Repaso String Bucle Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo con C++" << endl;
    cout << "2. Probar con otro texto" << endl;
    cout << "0. Salir" << endl;
}

void MostrarCaracteres(string texto)
{
    for (int i = 0; i < (int)texto.size(); i++)
    {
        cout << texto[i] << endl;
    }
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                MostrarCaracteres("C++");
                break;
            case 2: {
                string texto;
                cout << "Texto: ";
                cin >> texto;
                MostrarCaracteres(texto);
                break;
            }
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }
    } while (opcion != 0);
    return 0;
}
